package me.manicraft.casino.objects.games;

import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.objects.Game;
import me.manicraft.casino.objects.Person;

public class RandomNumber extends Game {

    public RandomNumber(String name) {
        super("ZuffalsZahl");
    }

    @Override
    public boolean play(Person p) {
        final int lower = 0;
        final int upper = 10;
        int random = MathUtils.getRandom(lower,upper);
        int input = ConsoleUtils.getUserInput("["+p.getName()+"]: Tippe auf eine Zahl zwischen "+lower+" und "+upper, lower, upper);

        int difference = Math.abs(random - input);
        return difference < 2;
    }
}
