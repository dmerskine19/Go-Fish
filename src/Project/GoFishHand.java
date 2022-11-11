
package project;

import java.util.ArrayList;
import java.util.Random;

public class GoFishHand extends NewGroupOfCards {
    /** Size of the players hand.
     * @param givenSize - number of cards in their hand
     **/
    public GoFishHand(final int givenSize) {
        super(givenSize);
    }
    /** To create a hand of 7 cards.
     * @return cardHand - The cards in a players current hand.
     * @param cardHandTemp - Temp array to build the players hand
     **/
    public ArrayList<Card> generateHand(final ArrayList<Card> cardHandTemp) {
        ArrayList<Card> cardHand = new ArrayList<>();
        for (int i = 0; i < this.getSize(); i++) {
            int rdmCard = generateRandomNumber(cardHandTemp.size());
            Card card = cardHandTemp.get(rdmCard);
            cardHandTemp.remove(card);
            cardHand.add(card);
        }
        return cardHand;
    }


    /** Used to create random numbers.
     * @return rdm - A random number.
     * @param maxVal - The max value of the random number being generated
     **/
    public static int generateRandomNumber(final int maxVal) {
        Random rdm = new Random();
        return rdm.nextInt(maxVal);
    }

    //method to select a card from the hand
    /** Used to create random numbers.
     * @return currentPlayerHand.get(rdm) - A random card from the players hand.
     * @param currentPlayerHand - The players current hand
     **/
    public static Card rdmCardFromHand(final ArrayList<Card> currentPlayerHand) {
        int rdm = generateRandomNumber(currentPlayerHand.size());
        return (currentPlayerHand.get(rdm));
    }

}