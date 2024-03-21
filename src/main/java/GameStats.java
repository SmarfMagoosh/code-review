package main.java;

import java.util.ArrayList;

/**
 * An interface for a data structure, DB API, file reader, etc. that
 * tells us how many games were played that took some number of guesses
 * (e.g., How many games took 8 guesses? --> 17)
 * You can edit this file, but the two abstract methods listed below must remain
 */
public abstract class GameStats {
    private static final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    /**
     * @return the number of games played that took numGuesses
     */
    public abstract int numGames(int numGuesses);

    /**
     * @return the maximum number of guesses that any game took
     */
    public abstract int maxNumGuesses();

    public static ArrayList<String> getBinNames() {
        ArrayList<String> names = new ArrayList<>();
        for(int binIndex = 0; binIndex < BIN_EDGES.length; binIndex++) {
            names.add(getBinName(binIndex));
        }
        return names;
    }

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

    public ArrayList<Integer> getLabels() {
        ArrayList<Integer> labels = new ArrayList<>();
        for (int binIndex = 0; binIndex < BIN_EDGES.length; binIndex++) {
            int numGames = this.countGames(binIndex);
            labels.add(numGames);
        }
        return labels;
    }

    private int countGames(int binIndex) {
        int lowerBound = BIN_EDGES[binIndex];
        boolean lastBin = binIndex == BIN_EDGES.length - 1;
        int numGames = 0;

        int maxIndex = lastBin ? this.maxNumGuesses() : BIN_EDGES[binIndex + 1];

        for(int numGuesses = lowerBound; numGuesses < maxIndex; numGuesses++){
            numGames += this.numGames(numGuesses);
        }

        return numGames;
    }
}
