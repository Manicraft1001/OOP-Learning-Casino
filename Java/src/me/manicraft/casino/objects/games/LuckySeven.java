package me.manicraft.casino.objects.games;

import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.objects.Game;
import me.manicraft.casino.objects.Person;

import java.util.Arrays;
import java.util.List;

public class LuckySeven extends Game {

    public LuckySeven(String name) {
        super(name);
    }

    private List<Integer> numbers = Arrays.asList(2,11,10,5,8);
    private int multiply;
    private int numb1;
    private int numb2;
    private int input;

    @Override
    public boolean play(Person p) {
        // Prepare console, show graphical playground
        ConsoleUtils.clear();

        // Get a number from user input
        final int a = ConsoleUtils.getUserInput("["+p.getName()+"]: Bitte setze auf eine Zahl",0,12);
        this.input = a;

        // Get two random numbers from random
        int b1 = MathUtils.getRandom(0,6);
        int b2 = MathUtils.getRandom(0,6);

        this.numb1 = b1;
        this.numb2 = b2;

        // Calculate total of both random numbers
        int sum = b1 + b2;

        // Multiply pot by 3 if total is 7 and user provided 7
        if (a == 7 && sum == a) {
            this.multiply = 3;
            return true;

            // Multiply pot by 2 if total is in list and total equals input
        } else if (numbers.contains(sum) && a == sum) {
            this.multiply = 2;
            return true;

            // Multiply pot by 1 if total equals input
        } else if (sum == a) {
            this.multiply = 1;
            return true;

            // Multiply by 0 if nothing is the case
        } else {
            this.multiply = 0;
            return false;
        }
    }

    @Override
    public int payWin(int pot) {
        return super.payWin(pot * this.multiply);
    }

    public int getNumb1() {
        return numb1;
    }

    public int getNumb2() {
        return numb2;
    }

    public int getInput() {
        return input;
    }
}
