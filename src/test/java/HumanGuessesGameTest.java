package test.java;

import org.mockito.Mockito.*;

import main.java.GuessResult;
import main.java.HumanGuessesGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HumanGuessesGameTest {
    private HumanGuessesGame game;

    @Test
    public void testInitialization() {
        game = new HumanGuessesGame();
        assertNotNull(game);
        assertEquals(0, game.getNumGuesses());
    }

    @Test
    public void testGuessingLogic() {
        game = new HumanGuessesGame();
        // Test when the guessed value is lower than the target
        assertEquals(GuessResult.LOW, game.makeGuess(game.getTarget() - 1));

        // Test when the guessed value is higher than the target
        assertEquals(GuessResult.HIGH, game.makeGuess(game.getTarget() + 1));

        // Test when the guessed value is equal to the target
        assertEquals(GuessResult.CORRECT, game.makeGuess(game.getTarget()));
    }

    @Test
    public void testNumGuesses() {
        game = new HumanGuessesGame();
        assertEquals(0, game.getNumGuesses());

        game.makeGuess(50);
        game.makeGuess(75);
        game.makeGuess(100);

        assertEquals(3, game.getNumGuesses());
    }

}
