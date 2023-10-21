package ru.netology.gamecoll;

import ru.netology.gamecoll.exception.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        if (player != null) {
            players.put(player.getName(), player);
        }
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Either player with name '" + playerName1
                    + "' or player with name '" + playerName2 + "' is not registered in the game");
        }
        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();
        return strength1 > strength2 ? 1 : (strength2 > strength1 ? 2 : 0);
    }

    private Player findPlayerByName(String playerName) {
        return players.get(playerName);
    }

    public Map<String, Player> getPlayers() {
        return players;
    }
}
