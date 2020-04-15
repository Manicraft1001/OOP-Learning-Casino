package me.manicraft.casino.objects;

import me.manicraft.casino.utils.ConsoleUtils;

import java.util.ArrayList;

/**
 * Instance for creating a table and managing players, games and more
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.1
 * @since 1.0
 */

public class DealTable {

    private Game activity;
    private Employee croupier;
    private ArrayList<Player> players;
    private int pot;

    public DealTable(Game activity, Employee croupier) {
        this.activity = activity;
        this.croupier = croupier;
        this.players = new ArrayList<>();
        this.pot = 0;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public void setActivity(Game activity) {
        this.activity = activity;
    }

    public void setCroupier(Employee croupier) {
        this.croupier = croupier;
    }

    public void addPlayer(Player player) {
        ConsoleUtils.log(player.getName()+" ist dem Spiel Tisch beigetreten (Game: "+this.getActivity().getName()+").");
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        ArrayList<Player> players = this.getPlayers();
        players.remove(player);
        this.setPlayers(players);

        ConsoleUtils.log(player.getName()+" hat den Tisch verlassen (Game: "+this.getActivity().getName()+").");
    }

    private void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Game getActivity() {
        return activity;
    }

    public Employee getCroupier() {
        return croupier;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void showInfo() {
        String leftAlignFormat = "| %-11s | %-10s | %-8s |%n";

        System.out.format("+-------------+------------+----------+%n");
        System.out.format("|  Game Name  |  Croupier  |  Player  |%n");
        System.out.format("+-------------+------------+----------+%n");
        for (int i = 0; i < getPlayers().size(); i++) {
            System.out.format(leftAlignFormat, this.getActivity().getName(), this.getCroupier().getName(), this.getPlayers().get(i) != null ? this.getPlayers().get(i).getName() : "");
        }
        System.out.format("+-------------+------------+----------+%n");
    }
}
