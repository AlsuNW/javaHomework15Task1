import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class GameTest {

    @Test
    public void shouldReturn1IfPlayer1Wins() {
        Player player1 = new Player(55, "James", 67);
        Player player2 = new Player(88, "John", 53);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("James", "John");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2IfPlayer2Wins() {
        Player player1 = new Player(55, "James", 76);
        Player player2 = new Player(88, "John", 85);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("James", "John");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0IfDraw() {
        Player player1 = new Player(55, "James", 67);
        Player player2 = new Player(88, "John", 67);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("James", "John");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIfPlayer1NotRegistered() {
        Player player1 = new Player(55, "James", 67);
        Player player2 = new Player(88, "John", 67);

        Game game = new Game();

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Anna", "James"));
    }

    @Test
    public void shouldThrowIfPlayer2NotRegistered() {
        Player player1 = new Player(55, "James", 67);
        Player player2 = new Player(88, "John", 67);

        Game game = new Game();

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("James", "Anna"));
    }

    @Test
    public void shouldThrowIfPlayersNotRegistered() {
        Player player1 = new Player(55, "James", 67);
        Player player2 = new Player(88, "John", 67);

        Game game = new Game();

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Anna", "Julia"));
    }
}
