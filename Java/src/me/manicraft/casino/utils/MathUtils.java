package me.manicraft.casino.utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utils class for calculating some math operations
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 */

public class MathUtils {

    /**
     * Checks, if provided String is a numeric value
     * @param a The String to check
     * @return boolean if variable is a number or not
     */
    public static boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Calculates a random number, based on built-in Math library
     * @param lower lower bound of random number
     * @param upper upper bound of random number
     * @return returns a random number
     */
    public static int getRandom(int lower, int upper) {
        return (int) (Math.random() * upper + lower);
    }

    /**
     * Repeats a specific String multiple times
     * @param count Count how often string should get repeated
     * @param with String which should get repeated
     * @return Returns repeated String
     */
    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    /**
     * Random shuffle of array (Fisher–Yates Algorithm: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)
     * @param ar array to shuffle
     */
    public static ArrayList<String> shuffleArray(ArrayList<String> ar) {
        ArrayList<String> b = new ArrayList<>();
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar.get(i);
            ConsoleUtils.log("Setting "+index+" to element with index "+i+" ("+ar.get(i)+")");
            b.set(index, ar.get(i));
            b.set(i, a);
        }
        return b;
    }
}
