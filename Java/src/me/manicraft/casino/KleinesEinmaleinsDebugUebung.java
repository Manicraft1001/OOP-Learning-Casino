package me.manicraft.casino;

/**
 * Small test class for assignment "Debugging"
 * Contains main method to start
 */

public class KleinesEinmaleinsDebugUebung {

    /**
     * Main Method to start Debug Assignment
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder linie;
        int resultat;
        String[] kleinesEinmaleins = new String[10];

        int i = 0;
        while (i < 10) {
            i++;
            linie = new StringBuilder((String.valueOf(i).length() < 2 ? " "+i : i) + "-er Reihe:"); //Changed to StringBuilder due while loop String modification

            int j = 0;
            while (j < 10) {
                resultat = i * ++j;
                linie.append(resultat < 100 ? (resultat < 10 ? "   " + resultat : "  " + resultat) : " " + resultat); //Appends new number, adds spaces for table layout (was too lazy to format it properly xD)
            }
            kleinesEinmaleins[i-1] = linie.toString();
        }
        for (String s : kleinesEinmaleins) {
            System.out.println(s);
        }
    }

}
