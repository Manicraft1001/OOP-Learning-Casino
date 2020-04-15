package me.manicraft.casino.handler;

import me.manicraft.casino.objects.DealTable;
import me.manicraft.casino.objects.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler class for managing games and detect free tables
 * @author Manuel Ruwe
 * @author www.ict-campus.net
 * @version 1.3
 * @since 1.2
 */

public class GameManager {

    private List<DealTable> tables = new ArrayList<>();

    public List<DealTable> getTables() {
        return tables;
    }

    public void addTable(DealTable table) {
        tables.add(table);
    }

    public void finishTable(DealTable table) {
        tables.remove(table);
    }

    public boolean isGameAvabile(Game game) {
        for (DealTable table : tables)
            if (table.getActivity().getName().equals(game.getName()) && table.getPlayers().size() < 10)
                return true;
        return false;
    }

    public DealTable getAvaibleDealTable(Game game) {
        for (DealTable table : tables)
            if (table.getActivity().getName().equals(game.getName()) && table.getPlayers().size() < 10)
                return table;
        return null;
    }
}
