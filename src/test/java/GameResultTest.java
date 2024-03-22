package test.java;

import main.java.GameResult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameResultTest {

    @Test
    public void humanGuessesFirstTry() {
        GameResult gr = new GameResult(true, 0, 1);
        assertEquals("You guessed it on the first try!", gr.getNumGuessesText());
    }

    @Test
    public void computerGuessesFirstTry() {
        GameResult gr = new GameResult(false, 0, 1);
        assertEquals("I guessed it on the first try!", gr.getNumGuessesText());
    }

    @Test
    public void humanGuessesAfterSeveralTries() {
        GameResult gr = new GameResult(true, 0, 7);
        assertEquals("It took you 7 guesses.", gr.getNumGuessesText());
    }

    @Test
    public void computerGuessesAfterSeveralTries() {
        GameResult gr = new GameResult(false, 0, 7);
        assertEquals("It took me 7 guesses.", gr.getNumGuessesText());
    }

    // TODO: test saveResults
}
