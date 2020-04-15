package me.manicraft.casino.objects.games;

import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.objects.Game;
import me.manicraft.casino.objects.Person;

public class RandomGuess extends Game {

    private int counter;

    public RandomGuess(String name) {
        super(name);
    }

    @Override
    public boolean play(Person p) {
        // Prepare console, show graphical playground
        ConsoleUtils.clear();
        counter = 0;

        int rnd = MathUtils.getRandom(0, 100);

        while (true) {
            int input = ConsoleUtils.getUserInput("Guess the random: ", 0, 100);
            counter++;

            if (input == rnd) {
                return true;
            } else if (Math.abs(input - rnd) < 5) {
                ConsoleUtils.log("["+p.getName()+"] Du warst Nahe dran!");
            } else {
                ConsoleUtils.log("["+p.getName()+"] Falsch, versuche es erneut!");
            }
        }
    }

    @Override
    public int payWin(int pot) {
        return super.payWin(4 * (pot / this.counter));
    }

}
