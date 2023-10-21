package ru.netology.gamecoll;

import ru.netology.gamecoll.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (player != null) {
            players.add(player);
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
        Player found = null;
        if (playerName != null) {
            for (Player player : players) {
                if (playerName.equals(player.getName())) {
                    found = player;
                    break;
                }
            }
        }
        return found;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
