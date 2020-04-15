package me.manicraft.casino.objects.games;

import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.objects.Game;
import me.manicraft.casino.objects.Person;
import me.manicraft.casino.utils.TimeUtils;

import javax.swing.*;

public class TicTacToe extends Game {

    public TicTacToe(String name) {
        super("TicTacToe");
    }

    // Create a two dimensional array for playground
    private char[][] playground = new char[3][3];

    // Fill all spaces with an empty char
    public void initPlayground() {
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                playground[x][z] = ' ';
            }
        }
    }

    @Override
    public boolean play(Person p) {
        while (true) {
            // Prepare console, show graphical playground
            ConsoleUtils.clear();
            printField();

            // Listens for coordinates from user input and insert them, if the field is empty
            while (true) {
                int x = ConsoleUtils.getUserInput("["+p.getName()+"]: X Koordinate: ", 0, 3);
                int y = ConsoleUtils.getUserInput("["+p.getName()+"]: Y Koordinate: ", 0, 3);

                if (playground[y][x] == ' ') {
                    playground[y][x] = 'X';
                    break;
                } else {
                    ConsoleUtils.log("["+p.getName()+"]: Dieses Feld ist bereits besetzt. Wähle ein anderes.");
                }
            }

            // Prepare console, show graphical playground
            ConsoleUtils.clear();
            printField();

            // Ends the game, if the game is full or a winner has 3 in a row
            if (isBoardFull() && !checkForWin()) {
                JOptionPane.showMessageDialog(null,"Niemand hat das TicTacToe gewonnnen!");
                return false;
            } else if (checkForWin()) {
                char winner = getWinner();
                return winner == 'X';
            }

            System.out.println("Dein Gegner sucht sich ein Feld heraus.");
            TimeUtils.sleep(2);

            // Selects randomly a field and fills in a circle
            while (true) {
                int x = MathUtils.getRandom(0,3);
                int y = MathUtils.getRandom(0,3);
                if (playground[y][x] == ' ') {
                    playground[y][x] = 'O';
                    break;
                }
            }

            // Ends the game, if the game is full or a winner has 3 in a row
            if (isBoardFull() && !checkForWin()) {
                JOptionPane.showMessageDialog(null,"Niemand hat das TicTacToe gewonnnen!");
                return false;
            } else if (checkForWin()) {
                char winner = getWinner();
                return winner == 'X';
            }
        }
    }

    private void printField() {
        ConsoleUtils.log("TIC TAC TOE\n");
        String leftAlignFormat = MathUtils.repeat(5," ")+"| %-3d | %-3s | %-3s | %-3s |%n";

        System.out.format(MathUtils.repeat(5," ")+"+-----+-----+-----+-----+%n");
        System.out.format(MathUtils.repeat(5," ")+"| Row |  0  |  1  |  2  |%n");
        System.out.format(MathUtils.repeat(5," ")+"+-----+-----+-----+-----+%n");
        for (int i = 0; i < playground.length; i++) {
            System.out.format(leftAlignFormat, i, playground[i][0], playground[i][1], playground[i][2]);
        }
        System.out.format(MathUtils.repeat(5," ")+"+-----+-----+-----+-----+%n");
    }


    private boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (playground[i][j] == ' ') {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    private boolean checkForWin() {
        return (checkRowsForWin() != ' ' || checkColumnsForWin() != ' ' || checkDiagonalsForWin() != ' ');
    }

    private char getWinner() {
        if (checkRowsForWin() != ' ')
            return checkRowsForWin();
        if (checkColumnsForWin() != ' ')
            return checkColumnsForWin();
        if (checkDiagonalsForWin() != ' ')
            return checkDiagonalsForWin();
        return ' ';
    }

    private char checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(playground[i][0], playground[i][1], playground[i][2]))
                return playground[i][0];
        }
        return ' ';
    }

    private char checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(playground[0][i], playground[1][i], playground[2][i]))
                return playground[0][i];
        }
        return ' ';
    }

    private char checkDiagonalsForWin() {
        if (checkRowCol(playground[0][0], playground[1][1], playground[2][2]))
            return playground[0][0];
        if (checkRowCol(playground[0][2], playground[1][1], playground[2][0]))
            return playground[0][2];
        return ' ';
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return c1 != ' ' && c1 == c2 && c2 == c3;
    }
}
