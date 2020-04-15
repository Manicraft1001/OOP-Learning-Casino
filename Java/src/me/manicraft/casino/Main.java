package me.manicraft.casino;

import me.manicraft.casino.handler.GameManager;
import me.manicraft.casino.objects.NavigationMenu;
import me.manicraft.casino.objects.Person;
import me.manicraft.casino.objects.Player;
import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.sql.PersonJDBCDao;

import java.util.List;

/**
 * The main class
 * This class provides some methods for starting all necessary things
 * Developers can include their test statements here
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.5
 * @since 1.2
 */

public class Main {

    private static Main instance;
    private static GameManager gm;

    public static void main(String[] args) {
        // Creating new instances for accessing main methods and game manager
        instance = new Main();
        gm = new GameManager();

        // Start main method
        instance.start();
    }

    private Player moritz = new Player("Meier","Möru",2000);
    private Player rita = new Player("Bürki","Ritle",1975);
    private Player elvis = new Player("Presley","King",1935);

    /**
     * Main Task to check some things, add some values and start menu
     */
    private void start() {
        // Breaks current task, if program is opened in shell without console, for ex. IntelliJ Idea

        moritz.earnMoney(1000);
        rita.earnMoney(2500);
        elvis.earnMoney(800);

        // Prepares console for printing main menu
        ConsoleUtils.clear();

        List<Person> people = new PersonJDBCDao().findAll();
        System.out.print("Personen aus Datenbank abgefragt: ");
        for (int i = 0; i < people.size(); i++) {
            System.out.print(i + 1 == people.size() ? people.get(i).getName() + "("+((Player)people.get(i)).getCredits() + "$)" : people.get(i).getName() + "("+((Player)people.get(i)).getCredits() + "$)" + ", ");
        }

        // Creates a new navigation menu instance
        new NavigationMenu(moritz).openMainNavigation();
    }

    /**
     * Get the Instance from Main class
     * @return Returns Instance of main class
     */
    public static Main getInstance() {
        return instance;
    }


    /**
     * Get the current GameManager instance
     * @return Returns the current GameManager Instance.
     */
    public static GameManager getGm() {
        return gm;
    }
}
