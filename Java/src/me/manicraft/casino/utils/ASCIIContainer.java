package me.manicraft.casino.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Utils class for Saving some ascii art :)
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 */

public class ASCIIContainer {

    /**
     * This method will return the ascii Art for the Casino Logo
     * When printing it out, split it by \n char and print each new part on a new line
     * @return Ascii Art in a string, split it by \n
     */
    public static String getWelcome_message() {
        return "\n" +
                "\n" +
                " ______     ______     ______     __     __   __     ______    \n" +
                "/\\  ___\\   /\\  __ \\   /\\  ___\\   /\\ \\   /\\ \"-.\\ \\   /\\  __ \\   \n" +
                "\\ \\ \\____  \\ \\  __ \\  \\ \\___  \\  \\ \\ \\  \\ \\ \\-.  \\  \\ \\ \\/\\ \\  \n" +
                " \\ \\_____\\  \\ \\_\\ \\_\\  \\/\\_____\\  \\ \\_\\  \\ \\_\\\\\"\\_\\  \\ \\_____\\ \n" +
                "  \\/_____/   \\/_/\\/_/   \\/_____/   \\/_/   \\/_/ \\/_/   \\/_____/ \n" +
                "                                                               \n" +
                "\n";
    }

    private static List<String> greetings = Arrays.asList("Hello","Welcome","Whats up?","How are you doing?","Good to see you","Howdy","Whazzup");

    /**
     * This method is returning a random greeting
     * You can use them for the startup display or to welcome a new user to a table
     * @return Returns a random greeting word
     */
    public static String getGreeting() {
        return greetings.get(MathUtils.getRandom(0, greetings.size()));
    }

    public static String getPentagramm() {
        return "\n" +
                "\n" +
                "\n" +
                "___________________6666666___________________ \n" +
                "____________66666__________66666_____________ \n" +
                "_________6666___________________666__________ \n" +
                "_______666__6____________________6_666_______ \n" +
                "_____666_____66_______________666____66______ \n" +
                "____66_______66666_________66666______666____ \n" +
                "___66_________6___66_____66___66_______666___ \n" +
                "__66__________66____6666_____66_________666__ \n" +
                "_666___________66__666_66___66___________66__ \n" +
                "_66____________6666_______6666___________666_ \n" +
                "_66___________6666_________6666__________666_ \n" +
                "_66________666_________________666_______666_ \n" +
                "_66_____666______66_______66______666____666_ \n" +
                "_666__666666666666666666666666666666666__66__ \n" +
                "__66_______________6____66______________666__ \n" +
                "___66______________66___66_____________666___ \n" +
                "____66______________6__66_____________666____ \n" +
                "_______666___________666___________666_______ \n" +
                "_________6666_________6_________666__________ \n" +
                "____________66666_____6____66666_____________ \n" +
                "___________________6666666___________________ \n" +
                "\n " +
                "\n ";
    }
}
