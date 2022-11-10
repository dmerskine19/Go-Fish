package project;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class GoFish extends Game {
    SetOfCards setPlayer1 = new SetOfCards();
    SetOfCards setPlayer2 = new SetOfCards();
    private ArrayList<Card> hand1 = null;
    private ArrayList<Card> hand2 = null;
    ArrayList<Card> fullHand52 = null;
    private String currentPlayer = null;
    private boolean gameEnd = false;
    private int numPlayer;

    String Comp = "Ai Opponent";

    public GoFish() {
        super();
    }


    public void addPlayers() {
        setPlayers();
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public void createHands() {
        int deckSize = 52;
        NewGroupOfCards newDeck = new NewGroupOfCards(deckSize);
        newDeck.shuffle();
        fullHand52 = newDeck.generateCards();

        //Generate hand1(7 cards) for Player 1
        int startingSizeofHand = 7;
        GoFishHand handPlayer1 = new GoFishHand(startingSizeofHand);
        hand1 = handPlayer1.generateHand(fullHand52);
        fullHand52.removeAll(hand1);

        //Generate hand2(7 cards) for Player 2
        GoFishHand handPlayer2 = new GoFishHand(startingSizeofHand);
        hand2 = handPlayer2.generateHand(fullHand52);
        fullHand52.removeAll(hand2);
    }

        public void play() {
            switch (numPlayer) {
                case 1:
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Go Fish Requires 2 or more players, To be played.");
                    System.out.println("Currently out game only supports 1 player vs an AI.");
                    System.out.println("Please enter 2 when asked for the number of players.");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

                case 2:
                    System.out.println("Starting Game...");
                    currentPlayer = Comp;
                    //printHand("Computer's", hand1);
                    printHand("Your Hand: ", hand2);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(" ");

                    while (!gameEnd) {
                        while (currentPlayer.equals(Comp)){
                            if (hand1.size() == 0) {
                                gameEnd = true;
                                break;
                            }
                            Card rdmSelection = GoFishHand.selectRandomCardFromHand(hand1);
                            ArrayList<Card> hand1Match = askCardFromOtherPlayer(rdmSelection, hand2);
                            System.out.println(" ");
                            System.out.println("Your Opponent asked for a " + rdmSelection.getValue());

                            if (hand1Match.size() > 0) {
                                hand2.removeAll(hand1Match);
                                hand1.addAll(hand1Match);
                                System.out.println("The Ai Opponent took the " + rdmSelection.getValue() + " of " + rdmSelection.getSuit() + " From your hand.");
                                System.out.println(" ");

                                if(SetOfCards.checkIfSetInHand(hand1)) {
                                    currentPlayer = Comp;
                                    System.out.println("The Ai Opponent Played the Set of " + rdmSelection);

                                    ArrayList<Card> set1;
                                    set1 = SetOfCards.findSetInHand(hand1);


                                    setPlayer1.addSetCount();
                                    hand1.removeAll(set1);

                                    //printHand("Computer's", hand1);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    printHand("Your Hand: ", hand2);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(" ");
                                    System.out.println(" ");

                                }
                                else {
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("Current Player " + currentPlayer);

                                    //printHand("Computer's", hand1);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    printHand("Your Hand: ", hand2);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    break;
                                }
                            }
                            else {
                                System.out.println("You don't have a " + rdmSelection.getValue() + " of " + rdmSelection.getSuit() + " in your hand...");
                                System.out.println("GO FISH!");
                                System.out.println(" ");
                                System.out.println("~~~~~A Card Has Been Added to your Opponents Hand~~~~~");
                                System.out.println(" ");

                                if (fullHand52.size() == 0) {
                                    gameEnd = true;
                                    break;
                                }
                                Card rdmSelection2 = GoFishHand.selectRandomCardFromHand(fullHand52);
                                fullHand52.remove(rdmSelection2);
                                hand1.add(rdmSelection2);

                                //printHand("Computer's", hand1);
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                printHand("Your Hand:", hand2);
                                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

                                if (SetOfCards.checkIfSetInHand(hand1)) {
                                    currentPlayer = "player1";
                                    System.out.println("Current Player " + currentPlayer);

                                    ArrayList<Card> book1;
                                    book1 = SetOfCards.findSetInHand(hand1);

                                    setPlayer1.addSetCount();
                                    hand1.removeAll(book1);

                                    //printHand("Computer's", hand1);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    printHand("Your Hand:", hand2);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

                                } else {
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("==========================================================================================================================================================");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("==========================================================================================================================================================");
                                    break;
                                }
                            }
                        }

                        while (currentPlayer.equalsIgnoreCase(Player.getPlayerID())) {
                            if (hand2.size() == 0) {
                                gameEnd = true;
                                break;
                            }
                            System.out.println("Please request a value you wish to take from the Ai Opponent");
                            System.out.println("You should have at least one in your hand (1-13)");
                            Scanner scanner = new Scanner(System.in);
                            int val = scanner.nextInt();
                            ArrayList<Card> hand2Match = askCardFromOtherPlayer(val, hand1);

                            if (hand2Match.size() > 0) {
                                hand1.removeAll(hand2Match);
                                hand2.addAll(hand2Match);
                                System.out.println("The Ai Opponent had a card with the value " + val + "!");
                                System.out.println("It was added to your hand");
                                System.out.println(" ");
                                if(SetOfCards.checkIfSetInHand(hand2)) {
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("This gives " + currentPlayer + " a set of 4!");

                                    ArrayList<Card> set2;
                                    set2 = SetOfCards.findSetInHand(hand2);

                                    setPlayer2.addSetCount();
                                    hand2.removeAll(set2);


                                } else {
                                    currentPlayer = Comp;
                                    System.out.println("==========================================================================================================================================================");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("==========================================================================================================================================================");

                                }
                                break;
                            }
                            else {
                                System.out.println("Go Fish!");
                                System.out.println(" ");
                                System.out.println("Type d to draw a card");
                                String ans = scanner.next();
                                while(ans.charAt(0) != 'd'){
                                    System.out.println("Type d to draw a card");
                                }
                                System.out.println(" ");

                                if (fullHand52.size() == 0) {
                                    gameEnd = true;
                                    break;
                                }

                                drawnCard();

                                if (SetOfCards.checkIfSetInHand(hand2)) {
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

                                    ArrayList<Card> set2;
                                    set2 = SetOfCards.findSetInHand(hand2);

                                    setPlayer2.addSetCount();
                                    hand2.removeAll(set2);

                                    //printHand("Computer's", hand1);
                                    printHand("Your Hand:", hand2);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                }
                                else {
                                    currentPlayer = Comp;
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    break;
                                }
                            }
                        }
                        //printHand("Computer's", hand1);
                        printHand("Your Hand:", hand2);
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                    break;
                }
        }

    private void drawnCard(){
        Card rdmSelection31 = GoFishHand.selectRandomCardFromHand(fullHand52);
        fullHand52.remove(rdmSelection31);
        hand2.add(rdmSelection31);
        System.out.println("~~~~~The " + rdmSelection31.getValue() + " of " + rdmSelection31.getSuit() + " was added to your hand~~~~~");
        System.out.println(" ");
    }

    private void printHand(String player, ArrayList<Card> currentHand) {
        System.out.println(player + " (" + currentHand.size() + ")");
        for(Card card : currentHand) {
            System.out.print(card.getSuit() + " " + card.getValue() + " | ");
        }
        System.out.println();
    }

    //to get cards for the computer player from the other player or pack
    public ArrayList<Card> askCardFromOtherPlayer(Card requestedCard,ArrayList<Card> opponentPlayerHand) {
        ArrayList<Card> matchingCards = new ArrayList<>();
        if (Objects.equals(currentPlayer, Comp)) {
            for (Card card : opponentPlayerHand) {
                if (card.getValue() == requestedCard.getValue()) {
                    matchingCards.add(card);
                }
            }
        }
        return matchingCards;
    }
    public ArrayList<Card> askCardFromOtherPlayer(int val,ArrayList<Card> opponentPlayerHand){
        ArrayList<Card> matchingCards = new ArrayList<>();
        System.out.println(" ");
        System.out.println("~~~~~You asked for a " + val + "~~~~~");
        System.out.println(" ");


        for(Card card : opponentPlayerHand) {
            if (card.getValue() == val) {

                matchingCards.add(card);
            }
        }
        return matchingCards;
    }


    public void declareWinner() {
        if (setPlayer1.countSet() > setPlayer2.countSet()) {
            System.out.println("Player 1 is the winner !");
        } else if (setPlayer2.countSet() > setPlayer1.countSet()) {
            System.out.println("" + Player.getPlayerID() + " is the winner !");
        } else {
            System.out.println("TIE !");
        }
        System.out.println("Player 1 - " + setPlayer1.countSet() + " sets");
        System.out.println("" + Player.getPlayerID() + " - " + setPlayer2.countSet() + " sets");
    }
}

