package main.java;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An interface for a data structure, DB API, file reader, etc. that
 * tells us how many games were played that took some number of guesses
 * (e.g., How many games took 8 guesses? --> 17)
 * You can edit this file, but the two abstract methods listed below must remain
 */
public abstract class GameStats {
    protected static final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    public static final ArrayList<String> binNames = IntStream.range(0, BIN_EDGES.length)
            .mapToObj(GameStats::getBinName)
            .collect(Collectors.toCollection(ArrayList::new));

    /**
     * @return the number of games played that took numGuesses
     */
    public abstract int numGames(int numGuesses);

    /**
     * @return the maximum number of guesses that any game took
     */
    public abstract int maxNumGuesses();

    private static String getBinName(int binIndex) {
        if (binIndex == BIN_EDGES.length - 1) {
            // last bin
            return BIN_EDGES[binIndex] + " or more";
        } else {
            int upperBound = BIN_EDGES[binIndex + 1] - 1;
            if (upperBound > BIN_EDGES[binIndex]) {
                return BIN_EDGES[binIndex] + "-" + upperBound;
            } else {
                return Integer.toString(BIN_EDGES[binIndex]);
            }
        }
    }
}
