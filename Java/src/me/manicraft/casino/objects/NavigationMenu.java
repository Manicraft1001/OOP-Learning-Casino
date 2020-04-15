package me.manicraft.casino.objects;

import me.manicraft.casino.Main;
import me.manicraft.casino.objects.games.*;
import me.manicraft.casino.utils.ASCIIContainer;
import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.utils.StringUtils;
import net.ictcampus.javamodul.objects.games.*;

import java.util.Scanner;

/**
 * The instance for display a navigation and joining a game
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.2
 * @since 1.0
 */

public class NavigationMenu {

    private Player player;

    /**
     * Creates a new Menu Instance for provided Player
     * @param person Target Player
     */
    public NavigationMenu (Player person) {
        this.player = person;
    }

    private Player getPlayer() {
        return player;
    }

    /**
     * Opens Profile Menu for the current player instance
     */
    private void showProfile() {
        // Prepare Console for new screen
        ConsoleUtils.clear();

        for (String line : ASCIIContainer.getWelcome_message().split("\n")) {
            ConsoleUtils.log(line);
        }
        ConsoleUtils.log(MathUtils.repeat(18, " ") + "YOUR PROFILE ("+ Main.getGm().getTables().size()+" running Games)\n");

        // Generate a formatted table
        String leftAlignFormat = MathUtils.repeat(5," ")+"| %-10s | %-9s  | %-12d | %-14s |%n";
        System.out.format(MathUtils.repeat(5," ")+"+------------+------------+--------------+----------------+%n");
        System.out.format(MathUtils.repeat(5," ")+"|  Username  |    Name    |  Birthyear   |  Your balance  |%n");
        System.out.format(MathUtils.repeat(5," ")+"+------------+------------+--------------+----------------+%n");
        System.out.format(leftAlignFormat, this.getPlayer().getName(), this.getPlayer().getFirstName(), this.getPlayer().getBirthday(), this.getPlayer().getCredits()+" $");
        System.out.format(MathUtils.repeat(5," ")+"+------------+------------+--------------+----------------+%n");

        // Wait for enter
        ConsoleUtils.log("");
        ConsoleUtils.log("Press enter to return to menu");
        System.console().readLine();

        // Clear console, prepare, show main menu
        ConsoleUtils.clear();
        openMainNavigation();
    }

    /**
     * Open Main Menu for player object of class
     * This method is clearing the console and prints some ascii art
     */
    public void openMainNavigation() {
        // Get ASCII Code and split it by the new line char
        for (String line : ASCIIContainer.getWelcome_message().split("\n")) {
            ConsoleUtils.log(line);
        }
        ConsoleUtils.log(MathUtils.repeat(18, " ") + "YOUR CASINO AT ICT-CAMPUS ("+Main.getGm().getTables().size()+" running Tables)\n");

        // Get a random greeting sentence and print it out
        ConsoleUtils.log(ASCIIContainer.getGreeting()+", "+getPlayer().getName()+"\n");

        // Print out main navigation part with format
        String leftAlignFormat = MathUtils.repeat(5," ")+"%-30s -> %-80s%n";
        System.out.format(leftAlignFormat, "[1]: Benutzerkonto einsehen", "Zeige dein Konto an");
        System.out.format(leftAlignFormat, "[2]: (Spiel) Zufallszahl", "Kannst du den Zufall voraussehen?");
        System.out.format(leftAlignFormat, "[3]: (Spiel) TicTacToe", "Einfaches Prinzip - Einfacher Gewinn");
        System.out.format(leftAlignFormat, "[4]: (Spiel) LuckySeven", "Die glücklichen Sieben");
        System.out.format(leftAlignFormat, "[5]: (Spiel) RandomGuess", "Die magische Zahl der 100");
        System.out.format(leftAlignFormat, "[6]: (Spiel) BlackJack", "Keine Ahnung wie das Spiel geht (still in development :c)");
        System.out.format(leftAlignFormat, "[7]: Beenden", "Beende das Programm");

        ConsoleUtils.log("\n");

        // Execute specific action from user input
        while (true) {
            System.out.print("     Bitte Menupunkt auswählen: ");
            String a = new Scanner(System.in).nextLine();
            switch (a) {
                case "1":
                    ConsoleUtils.clear();
                    showProfile();
                    break;
                case "2":
                    playGame(this.player, new RandomNumber("ZufallsZahl"));

                    ConsoleUtils.clear();
                    openMainNavigation();
                    break;
                case "3":
                    playGame(this.player, new TicTacToe("TicTacToe"));

                    ConsoleUtils.clear();
                    openMainNavigation();
                    break;
                case "4":
                    playGame(this.player, new LuckySeven("LuckySeven"));

                    ConsoleUtils.clear();
                    openMainNavigation();
                    break;
                case "5":
                    playGame(this.player, new RandomGuess("RandomGuess"));

                    ConsoleUtils.clear();
                    openMainNavigation();
                    break;
                case "6":
                    playGame(this.player, new BlackJack("BlackJack"));

                    ConsoleUtils.clear();
                    openMainNavigation();
                    break;
                case "7":
                    System.exit(0);
                    break;
                case "666":
                    for (String line : ASCIIContainer.getPentagramm().replaceAll("_"," ").split("\n")) {
                        ConsoleUtils.log(line);
                    }
                    break;
                default:
                    ConsoleUtils.log("Die Option \""+a+"\" wurde leider nicht gefunden.");
                    break;
            }
        }
    }

    /**
     * Start a new game for an specific Player instance. Please provide an child of game superclass
     * A empty game for the player will be searched automatically
     * @param new_player The instance of the target player
     * @param game The instance of the target game
     */
    private static void playGame(Player new_player, Game game) {
        // Create a empty DealTable
        DealTable dealTable;

        // Checks, if any DealTable has a free place for the specific game
        if (Main.getGm().isGameAvabile(game) && Main.getGm().getAvaibleDealTable(game).getPlayers().size() < 10) {
            dealTable = Main.getGm().getAvaibleDealTable(game);

            // Creates a new table, if the program couldn't find any free table with target game
        } else {
            dealTable = new DealTable(game, new Employee("Ram", "Arbeitsspeicher", 1900));
            Main.getGm().addTable(dealTable);
        }


        // Add player instance to table, Welcome the new player and display some information's about the table
        dealTable.addPlayer(new_player);
        dealTable.getCroupier().sayWelcome();
        dealTable.showInfo();

        // Creates an endless loop for infinite games
        while (true) {

            // Creates a loop for each player at table
            for (Player player : dealTable.getPlayers()) {

                // Breaks if the current player has not anymore any credits
                if (player.getCredits() <= 0) {
                    Main.getGm().finishTable(dealTable);
                    ConsoleUtils.log("["+player.getName()+"] Du hast kein Geld mehr. Du wurdest vom Spiel entfernt. Eingabetaste drücken um weiterzufahren...");
                    dealTable.removePlayer(player);
                    System.console().readLine();
                    break;
                }

                // Put into the pot the stake of the player
                dealTable.setPot(dealTable.getPot() + player.putAtStake());

                // Do some extra actions if target game is TicTacToe
                if (game instanceof TicTacToe) {
                    ((TicTacToe)game).initPlayground();
                } else if (game instanceof BlackJack) {
                    ((BlackJack)game).initCards();
                }

                // Start play method for specific player
                if (dealTable.getActivity().play(player)) {
                    // Add the won amount of money to the players balance
                    int won = dealTable.getActivity().payWin(dealTable.getPot());
                    player.earnMoney(won);
                    ConsoleUtils.log("["+player.getName()+"] Herzlichen Glückwunsch, du hast gewonnen! (+"+won+"$)");

                    // Comfort the player
                } else {
                    ConsoleUtils.log("["+player.getName()+"] Du hast leider verloren! Beim nächsten Versuch wird es sicher was!");
                }
            }

            // Clear Pot and ask players if they want to continue playing
            dealTable.setPot(0);
            if (!ConsoleUtils.getUserInput("Möchten alle Teilnehmer ("+ StringUtils.arrayToString(dealTable.getPlayers())+") weiter spielen? (J/N): ")) {
                Main.getGm().finishTable(dealTable);
                break;
            }
        }
    }
}
