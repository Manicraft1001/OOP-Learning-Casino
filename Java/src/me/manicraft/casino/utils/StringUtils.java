package me.manicraft.casino.utils;

import me.manicraft.casino.objects.Player;

import java.util.ArrayList;

/**
 * Utils class for parsing some String values
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 */

public class StringUtils {

    /**
     * Returns a String with all members of table, separated by comma
     * @param people List of people in Table
     * @return returns a String of all members
     */
    public static String arrayToString(ArrayList<Player> people) {
        // Create a new String Builder
        StringBuilder str = new StringBuilder();

        // Iterate for each element in people
        for (int i = 0; i < people.size(); i++) {

            // Checks if current element is last element of list
            if (i + 1 >= people.size()) {
                // Append Username without comma
                str.append(people.get(i).getName());
            } else {
                // Append Username with comma
                str.append(people.get(i).getName()).append(", ");
            }
        }
        return str.toString();
    }

}
