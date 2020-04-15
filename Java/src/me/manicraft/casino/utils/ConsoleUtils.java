package me.manicraft.casino.utils;

import me.manicraft.casino.objects.exceptions.OutOfRangeException;

import javax.swing.*;
import java.io.IOException;

/**
 * Utils class for getting inputs from user and managing the console
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 */

public class ConsoleUtils {

    /**
     * Prints a text into console with little space between left border and text
     * @param s Text to print, String is expected -> Cast other objects to String
     */
    public static void log(String s) {
        System.out.println(MathUtils.repeat(5," ")+s);
    }

    /**
     * Get a user input from GUI
     * @param hint Provide a hint for the user to explain expected value, can be empty
     * @param lower Lower bound for returned int value
     * @param upper upper bound for returned int value
     * @return returns a number, provided by the user
     */
    public static int getUserInput(String hint, int lower, int upper) {
        // Make endless loop
        while (true) {

            // Get Input from GUI
            final String input = JOptionPane.showInputDialog(null, hint.length() > 0 ? hint : "Please provide an number: ");

            // Proof if input is a number
            if (MathUtils.isNumber(input)) {
                final int i = Integer.parseInt(input);

                // Checks, if number is in bound
                if (i >= lower && i < upper) {
                    return i;
                } else {
                    JOptionPane.showMessageDialog(null,"Please select a number between "+lower+" and "+upper+".");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Please provide an valid number");
            }
        }
    }



    /**
     * Get a user input from GUI (only test method to experiment with exceptions)
     * @param hint Provide a hint for the user to explain expected value, can be empty
     * @param lower Lower bound for returned int value
     * @param upper upper bound for returned int value
     * @return returns a number, provided by the user
     * @deprecated
     */
    public static int getUserInputExperiment(String hint, int lower, int upper) throws OutOfRangeException {
        // Make endless loop
        while (true) {

            // Get Input from GUI
            final String input = JOptionPane.showInputDialog(null, hint.length() > 0 ? hint : "Please provide an number: ");

            // Proof if input is a number
            if (MathUtils.isNumber(input)) {
                final int i = Integer.parseInt(input);

                // Checks, if number is in bound
                if (i >= lower && i < upper) {
                    return i;
                } else {
                    JOptionPane.showMessageDialog(null,"Please select a number between "+lower+" and "+upper+".");
                    throw new OutOfRangeException("Input out of bounds");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Please provide an valid number");
            }
        }
    }




    /**
     * Get a boolean from User Input
     * @param hint Provide a hint for the user to explain expected value, can be empty
     * @return returns a boolean, provided by the user
     */
    public static boolean getUserInput(String hint) {
        // Make endless loop
        while (true) {

            // Get Input from GUI
            final String input = JOptionPane.showInputDialog(null, hint.length() > 0 ? hint : "Please provide an boolean (J/N): ");

            // Fix an NullPointerException if no input is given
            if (input == null) {
                JOptionPane.showMessageDialog(null,"Please provide an valid answer (J/N)");
            } else {

                // Return boolean on input
                switch (input.toUpperCase()) {
                    case "J":
                    case "Y":
                    case "TRUE":
                    case "T":
                    case "YES":
                        return true;
                    case "N":
                    case "FALSE":
                    case "NO":
                        return false;
                    default:
                        JOptionPane.showMessageDialog(null,"Please provide an valid answer (J/N)");
                        break;
                }
            }
        }
    }

    /**
     * Clears the current console by executing cls command
     * @deprecated Works only on windows systems, will be removed in the future
     */
    public static void clear() {
        // Start a new process and run cls clear command. Could result in a InterruptedException or an IO Exception -> Handle Exceptions
        // Won't work on linux based systems
        //TODO: Create compatible clear command for linux systems
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {}
    }
}
