
package project;

public abstract class Game {
    /**Calls the main game function.**/
    public Game(){
    }

    /**Function for when multiple player are together.**/
    public void setPlayers() {
    }

    /**Function to call the main declareWinner function from startGame.**/
    public abstract void declareWinner();
}