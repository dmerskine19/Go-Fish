package project;


import java.util.Scanner;

class StartGame {

    public static void main(final String[] args) {
        GoFish game = new GoFish();
        game.play();
        game.declareWinner();
    }
}
