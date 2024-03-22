package test.java;

import main.java.ComputerGuessesGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesGameTest {
    @Test
    public void testGuessing() {
        // test game for every possible value
        for (int target = 1; target <= 1000; target++) {
            ComputerGuessesGame game = new ComputerGuessesGame();
            for (int i = 0; i < 15; i++) {
                if (game.getLastGuess() > target) {
                    game.lowGuess();
                } else if (game.getLastGuess() < target) {
                    game.highGuess();
                }
            }
            assertEquals(target, game.getLastGuess());
        }
    }

    @Test
    public void testNumGuesses() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        for (int numGuesses = 1; numGuesses < 20; numGuesses++) {
            game.lowGuess();
            assertEquals(numGuesses, game.getNumGuesses());
        }
    }
}
