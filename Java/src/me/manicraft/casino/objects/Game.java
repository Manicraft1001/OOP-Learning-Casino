package me.manicraft.casino.objects;

/**
 * The superclass for creating a game. Extend every new game by it
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.3
 * @since 1.2
 */

public abstract class Game {

    private String name;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean play(Person p);

    public int payWin(int pot) {
        return pot * 2;
    }
}
