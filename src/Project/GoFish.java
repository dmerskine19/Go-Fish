package project;

import java.util.Scanner;
import java.util.ArrayList;

public class GoFish extends Game {
    /**The sets of 4 cards player1 makes during the game.**/
    SetOfCards setPlayer1 = new SetOfCards();
    /**The sets of 4 cards player2 makes during the game.**/
    SetOfCards setPlayer2 = new SetOfCards();
    /**The Array of cards player1 has in their hand.**/
    private ArrayList<Card> hand1 = null;
    /**The Array of cards player1 has in their hand.**/
    private ArrayList<Card> hand2 = null;
    /**The Array of cards in the deck.**/
    ArrayList<Card> fullHand52 = null;
    /**A boolean that checks when the game is over.**/
    private boolean gameEnd = false;
    /**A user inputted number, that is the amount of players.**/
    private int numPlayer;

    /**First call to the GoFish class from StartGame.**/
    public GoFish() {
        super();
    }

    /**Adds players to the array containing the current players.**/
    public void addPlayers() {
        setPlayers();
    }
    /**Setter for the user inputted number of player.
     * @param numPlayer - user inputted value for the amount of players
     **/
    public void setNumPlayer(final int numPlayer) {
        this.numPlayer = numPlayer;
    }
    /**Creates each player's starting hand from the deck of 52 cards.**/
    public void createHands() {
        final int deckSize = 52; //Total number of cards in a deck
        NewGroupOfCards newDeck = new NewGroupOfCards(deckSize);
        newDeck.shuffle();
        fullHand52 = newDeck.generateCards();
        final int startingSizeofHand = 7; //number of cards in a hand at start.
        GoFishHand handPlayer1 = new GoFishHand(startingSizeofHand);
        hand1 = handPlayer1.generateHand(fullHand52);
        fullHand52.removeAll(hand1);
        GoFishHand handPlayer2 = new GoFishHand(startingSizeofHand);
        hand2 = handPlayer2.generateHand(fullHand52);
        fullHand52.removeAll(hand2);
    }
        /**Main play method for the game.**/
        public void play() {
            String comp = "Ai Opponent";
            switch (numPlayer) {
                case 1:
                    System.out.println("-------------------------------------");
                    System.out.println("Go Fish Requires 2 or more players.");
                    System.out.println("The game supports, 1 player vs an AI.");
                    System.out.println("Enter 2 for the number of players.");
                    System.out.println("-------------------------------------");

                case 2:
                    System.out.println("Starting Game...");
                    String currentPlayer = comp;
                    //printHand("Computer's", hand1);
                    printHand("Your Hand: ", hand2);
                    System.out.println("-------------------------------------");
                    System.out.println(" ");

                    while (!gameEnd) {
                        while (currentPlayer.equals(comp)) {
                            if (hand1.size() == 0) {
                                gameEnd = true;
                                break;
                            }
                            Card rdmSelec = GoFishHand.rdmCardFromHand(hand1);
                            ArrayList<Card> hand1M = askCard(rdmSelec.getValue(), hand2);
                            System.out.println(" ");
                            System.out.println("Opponent asked for " + rdmSelec.getValue());

                            if (hand1M.size() > 0) {
                                hand2.removeAll(hand1M);
                                hand1.addAll(hand1M);
                                System.out.println("The Ai Opponent took the " + rdmSelec.getValue() + " of " + rdmSelec.getSuit() + " From your hand.");
                                System.out.println(" ");

                                if (SetOfCards.checkIfSetInHand(hand1)) {
                                    currentPlayer = comp;
                                    System.out.println("Ai Opponent Played a Set of " + rdmSelec);

                                    ArrayList<Card> set1;
                                    set1 = SetOfCards.findSetInHand(hand1);


                                    setPlayer1.addSetCount();
                                    hand1.removeAll(set1);

                                    //printHand("Computer's", hand1);
                                    System.out.println("--------------------------------------");
                                    printHand("Your Hand: ", hand2);
                                    System.out.println("--------------------------------------");
                                    System.out.println(" ");
                                    System.out.println(" ");
                                }
                                else {
                                    System.out.println("--------------------------------------");
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("Current Player " + currentPlayer);

                                    //printHand("Computer's", hand1);
                                    System.out.println("--------------------------------------");
                                    printHand("Your Hand: ", hand2);
                                    System.out.println("--------------------------------------");
                                    break;
                                }
                            }
                            else {
                                System.out.println("You don't have a " + rdmSelec.getValue() + " of " + rdmSelec.getSuit() + " in your hand...");
                                System.out.println("GO FISH!");
                                System.out.println(" ");
                                System.out.println("~~~~~A Card Has Been Added to your Opponents Hand~~~~~");
                                System.out.println(" ");

                                if (fullHand52.size() == 0) {
                                    gameEnd = true;
                                    break;
                                }
                                Card rdmSelection2 = GoFishHand.rdmCardFromHand(fullHand52);
                                fullHand52.remove(rdmSelection2);
                                hand1.add(rdmSelection2);

                                //printHand("Computer's", hand1);
                                System.out.println("--------------------------------------");
                                printHand("Your Hand:", hand2);
                                System.out.println("--------------------------------------");

                                if (SetOfCards.checkIfSetInHand(hand1)) {
                                    currentPlayer = "player1";
                                    System.out.println("Current Player " + currentPlayer);

                                    ArrayList<Card> book1;
                                    book1 = SetOfCards.findSetInHand(hand1);

                                    setPlayer1.addSetCount();
                                    hand1.removeAll(book1);

                                    //printHand("Computer's", hand1);
                                    System.out.println("--------------------------------------");
                                    printHand("Your Hand:", hand2);
                                    System.out.println("--------------------------------------");

                                } else {
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("========================================");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("========================================");
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
                            ArrayList<Card> hand2Match = askCard(val, hand1);

                            if (hand2Match.size() > 0) {
                                hand1.removeAll(hand2Match);
                                hand2.addAll(hand2Match);
                                System.out.println("The Ai Opponent had a card with the value " + val + "!");
                                System.out.println("It was added to your hand");
                                System.out.println(" ");
                                if (SetOfCards.checkIfSetInHand(hand2)) {
                                    currentPlayer = Player.getPlayerID();
                                    System.out.println("This gives " + currentPlayer + " a set of 4!");

                                    ArrayList<Card> set2;
                                    set2 = SetOfCards.findSetInHand(hand2);

                                    setPlayer2.addSetCount();
                                    hand2.removeAll(set2);


                                } else {
                                    currentPlayer = comp;
                                    System.out.println("========================================");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("========================================");

                                }
                                break;
                            }
                            else {
                                System.out.println("Go Fish!");
                                System.out.println(" ");
                                System.out.println("Type d to draw a card");
                                String ans = scanner.next();
                                while (ans.charAt(0) != 'd') {
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
                                    System.out.println("========================================");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("========================================");

                                    ArrayList<Card> set2;
                                    set2 = SetOfCards.findSetInHand(hand2);

                                    setPlayer2.addSetCount();
                                    hand2.removeAll(set2);

                                    //printHand("Computer's", hand1);
                                    printHand("Your Hand:", hand2);
                                    System.out.println("-----------------------------------------");
                                }
                                else {
                                    currentPlayer = comp;
                                    System.out.println("-----------------------------------------");
                                    System.out.println("Current Player " + currentPlayer);
                                    System.out.println("-----------------------------------------");
                                    break;
                                }
                            }
                        }
                        //printHand("Computer's", hand1);
                        printHand("Your Hand:", hand2);
                        System.out.println("-----------------------------------------------------");
                    }
                    break;
                }
        }

    private void drawnCard() {
        Card rdmSelection31 = GoFishHand.rdmCardFromHand(fullHand52);
        fullHand52.remove(rdmSelection31);
        hand2.add(rdmSelection31);
        System.out.println("~~~~~The " + rdmSelection31.getValue() + " of " + rdmSelection31.getSuit() + " was added to your hand~~~~~");
        System.out.println(" ");
    }

    private void printHand(final String player, final ArrayList<Card> currentHand) {
        System.out.println(player + " (" + currentHand.size() + ")");
        for (Card card : currentHand) {
            System.out.print(card.getSuit() + " " + card.getValue() + " | ");
        }
        System.out.println();
    }
    /** Method that contains the logic for asking a player for a card.
     * @return matchingCards - All cards that match the users defined value
     * @param val - Defined value of card that is requested by the user
     * @param opponentPlayerHand - Defined player that the user is requesting a card from
     **/
    public ArrayList<Card> askCard(final int val, final ArrayList<Card> opponentPlayerHand) {
        ArrayList<Card> matchingCards = new ArrayList<>();
        System.out.println(" ");
        System.out.println("~~~~~You asked for a " + val + "~~~~~");
        System.out.println(" ");


        for (Card card : opponentPlayerHand) {
            if (card.getValue() == val) {

                matchingCards.add(card);
            }
        }
        return matchingCards;
    }

    /** Logic for declaring a winner of the game. **/
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

