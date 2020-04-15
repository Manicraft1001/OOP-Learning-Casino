package me.manicraft.casino.objects;

import me.manicraft.casino.utils.ConsoleUtils;

/**
 * The instance for creating a player. Child of Person
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.3
 * @since 1.0
 */

public class Player extends Person {

    private int credits;

    public Player(String name, String firstName, int birthday) {
        super(name, firstName, birthday);
    }

    public int putAtStake() {
        int sub = ConsoleUtils.getUserInput("["+this.getName()+"]: Your Stake (Konto: "+getCredits()+"$): ", 0, getCredits()+1);
        if (getCredits() >= sub) {
            this.credits = (this.getCredits() - sub);
            return sub;
        }
        return 0;
    }

    public int getCredits() {
        return credits;
    }

    public void earnMoney(int amount) {
        this.credits += amount;
    }
}
