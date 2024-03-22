package main.java;

import java.util.Random;

/**
 * A game where a human guesses a number between 1 and UPPER_BOUND
 * Tracks the target, the number of guesses made, and if the number has been guessed
 *
 * NOTE: You can refactor and edit this file if needed
 */
public class HumanGuessesGame {
    public final static int UPPER_BOUND = 1000;

    private final int target;
    private int numGuesses;

    public HumanGuessesGame(){
        Random randGen = new Random();
        this.target = randGen.nextInt(UPPER_BOUND) + 1;

        numGuesses = 0;
    }

    public GuessResult makeGuess(int value) throws IllegalArgumentException{
        numGuesses += 1;
        if (value < 0 || value > 1000){
            throw new IllegalArgumentException();
        }
        if(value < target){
            return GuessResult.LOW;
        }
        if(value > target){
            return GuessResult.HIGH;
        }

        return GuessResult.CORRECT;
    }

    public int getNumGuesses(){
        return numGuesses;
    }

//    public boolean isDone(){
//        return gameIsDone;
//    }

    public int getTarget() {
        return target;
    }
}
