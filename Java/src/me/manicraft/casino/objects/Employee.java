package me.manicraft.casino.objects;

import me.manicraft.casino.utils.ConsoleUtils;

/**
 * The instance for creating an employee. It is a child of Person
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.2
 * @since 1.0
 */

public class Employee extends Person {

    private int wage;

    Employee(String name, String firstName, int birthday) {
        super(name, firstName, birthday);
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    void sayWelcome() {
        ConsoleUtils.log("["+this.getName()+"] Herzlich Wllkommen im ICT Campus Test Casino");
    }
}
