package ru.netology.gamecoll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.gamecoll.exception.NotRegisteredException;

import java.util.Map;

public class GameTest {

    @Test
    public void testRegister() {
        String playerName = "Alex Brown";
        Player player1 = new Player(101, playerName, 100500);
        Game game = new Game();
        game.register(player1);
        Map<String, Player> playersFromGame = game.getPlayers();
        Assertions.assertNotNull(playersFromGame);
        Assertions.assertEquals(1, playersFromGame.size());
        Assertions.assertEquals(player1.getId(), playersFromGame.get(playerName).getId());
        // Test adding null player
        game.register(null);
        Assertions.assertEquals(1, playersFromGame.size());
    }

    @Test
    public void testGameRound() {
        String playerName1 = "Alex Brown";
        String playerName2 = "John Brown";
        String playerName3 = "Melissa Brown";
        Player player1 = new Player(101, playerName1, 100500);
        Player player2 = new Player(102, playerName2, 7500);
        Player player3 = new Player(103, playerName3, 7500);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertEquals(1, game.round(playerName1, playerName2));
        Assertions.assertEquals(2, game.round(playerName3, playerName1));
        Assertions.assertEquals(0, game.round(playerName2, playerName3));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(playerName1, "Vasilisa"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Luna", playerName3));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(null, playerName2));
    }
}
