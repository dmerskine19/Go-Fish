package project;

import java.util.ArrayList;
import java.util.Random;

public class GoFishHand extends NewGroupOfCards {

    public GoFishHand(int givenSize) {
        super(givenSize);
    }

    // To create a hand of 7 cards
    public ArrayList<Card> generateHand(ArrayList<Card> cardHandTemp) {
        ArrayList<Card> cardHand = new ArrayList<>();
        for (int i = 0; i < this.getSize(); i++) {
            int rdmCard = generateRandomNumber(cardHandTemp.size());
            Card card = cardHandTemp.get(rdmCard);
            cardHandTemp.remove(card);
            cardHand.add(card);
        }
        return cardHand;
    }

    // Built-in Random class is used to create random numbers
    public static int generateRandomNumber(int maxVal) {
        Random rdm = new Random();
        return rdm.nextInt(maxVal);
    }

    //method to select a card from the hand
    public static Card selectRandomCardFromHand(ArrayList<Card> currentPlayerHand) {
        int rdm = generateRandomNumber(currentPlayerHand.size());
        return (currentPlayerHand.get(rdm));
    }

}