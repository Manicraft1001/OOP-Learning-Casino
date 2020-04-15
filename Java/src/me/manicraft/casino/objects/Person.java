package me.manicraft.casino.objects;

/**
 * The instance for creating a person
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.0
 * @since 1.0
 */

public class Person {

    private String name;
    private String firstName;
    private int birthday;


    public Person(String name, String firstName, int birthday) {
        this.birthday = birthday;
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    int getBirthday() {
        return birthday;
    }

    String getFirstName() {
        return firstName;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean equals(Object o) {
        return o instanceof Person && ((Person)o).getName().equals(this.getName()) && ((Person)o).getBirthday() == this.getBirthday();
    }
}
