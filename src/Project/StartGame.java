package project;


import java.util.Scanner;

class StartGame {

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        String goFishSystem = "Go Fish System";
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome! This is the " + goFishSystem + " :)");
        System.out.println("This System currently only supports single player vs an AI.");
        System.out.println("Please enter 2, when asked for the number of players.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        GoFish game = new GoFish();
        int numPlayer = 2;
        game.setNumPlayer(numPlayer);
        System.out.println("Enter your name - ");
        String name = scanner.next();
        new NewPlayer(name);
        game.addPlayers();
        game.play();
        game.declareWinner();
    }
}
