package Project;


import java.util.Scanner;

public class StartGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String GoFishSystem = "Go Fish System";
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome! This is the " + GoFishSystem + " :)");
        System.out.println("This System currently only supports single player vs an AI.");
        System.out.println("Please enter 2, when asked for the number of players.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        GoFish game = new GoFish();
        System.out.println("Enter the number of players");
        int numPlayer = scanner.nextInt();
        game.setNumPlayer(numPlayer);
        game.createHands();
        System.out.println("Computer acts as Player 1");
        System.out.println("Enter the name of Player 2 which is you");
        String name = scanner.next();
        new NewPlayer(name);
        game.addPlayers();
        game.play();
        game.declareWinner();
    }
}
