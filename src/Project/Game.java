package project;

public abstract class Game {
    /**Calls the main game function.**/
    public Game() {
    }

    /**Function to call the main play function from startGame.**/
    public abstract void play();

    /**Function to call the main declareWinner function from startGame.**/
    public abstract void declareWinner();
}