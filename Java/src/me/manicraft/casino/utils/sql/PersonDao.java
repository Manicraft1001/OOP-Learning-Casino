package me.manicraft.casino.utils.sql;

import me.manicraft.casino.objects.Person;
import me.manicraft.casino.objects.Player;

import java.util.List;

public interface PersonDao {

    public Person findByName(String name);
    public List<Person> findAll();
    public void updateBalance(Player player, int i);
    public int getPersonIdentity(Person person);

}
