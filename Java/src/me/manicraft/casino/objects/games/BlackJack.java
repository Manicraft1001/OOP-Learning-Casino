package me.manicraft.casino.objects.games;

import me.manicraft.casino.utils.ConsoleUtils;
import me.manicraft.casino.utils.MathUtils;
import me.manicraft.casino.objects.Game;
import me.manicraft.casino.objects.Person;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackJack extends Game {

    private HashMap<String, Integer> cardsMap;
    private ArrayList<String> cardsList;

    public BlackJack(String name) {
        super(name);
    }

    @Override
    public boolean play(Person p) {
        //TODO: Make game
        return false;
    }

    public void initCards() {
        this.cardsMap = new HashMap<>();
        this.cardsMap.put("König",10);
        this.cardsMap.put("1",1);
        this.cardsMap.put("2",2);
        this.cardsMap.put("3",3);
        this.cardsMap.put("4",4);
        this.cardsMap.put("5",5);
        this.cardsMap.put("6",6);
        this.cardsMap.put("7",7);
        this.cardsMap.put("8",8);
        this.cardsMap.put("9",9);

        this.cardsList = new ArrayList<>();

        ArrayList<String> keys = new ArrayList<>();
        for (String set : this.cardsMap.keySet()) {
            keys.add(set);
        }

        ConsoleUtils.log("Keys: "+keys.toString());

        //TODO: Fix NullPointerException and Shuffle it randomly
        ConsoleUtils.log("Shuffled Array: "+ MathUtils.shuffleArray(keys).toString());
    }
}
