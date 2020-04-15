package me.manicraft.casino.utils.sql;

import me.manicraft.casino.objects.Person;
import me.manicraft.casino.objects.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonJDBCDao implements PersonDao {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public Person findByName(String name) {
        for (Person person : findAll())
            if (person.getName().equals(name))
                return person;
        return null;
    }

    @Override
    public List<Person> findAll() {
        List<Person> all = new ArrayList<>();

        String sql = "Select * from Person";
        try {
            con = openConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_PERSON");
                Player p = new Player(rs.getString("name"), rs.getString("prename"), rs.getInt("birthyear"));
                p.earnMoney(rs.getInt("credit"));
                all.add(p);
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }



    @Override
    public void updateBalance(Player player, int i) {
        if (i < 0)
            return;

        String sql = "UPDATE SET credit = ? WHERE ID_Person = ?";
        try {
            openConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ps.setInt(2, getPersonIdentity(player));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPersonIdentity(Person person) {
        String sql = "Select * from Person";
        try {
            con = openConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_PERSON");
                Player p = new Player(rs.getString("name"), rs.getString("prename"), rs.getInt("birthyear"));
                if (p.getName().equals(person.getName()))
                    return id;
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateBalance(Person person, int i) {
        if (person instanceof Player)
            updateBalance((Player)person, i);
    }

    private Connection openConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    private void closeConnection() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            System.err.println("Error in " + getClass().getName() + ": " + e.getMessage());
        }
    }
}
