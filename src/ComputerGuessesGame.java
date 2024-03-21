public class ComputerGuessesGame {
    private int numGuesses;
    private int lowerBound;
    private int upperBound;
    private int lastGuess;

    public ComputerGuessesGame() {
        numGuesses = 0;
        lowerBound = 1;
        upperBound = 1000;
        lastGuess = 501;
    }

    public void lowGuess() {
        upperBound = Math.min(upperBound, lastGuess);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public void highGuess() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }
}
