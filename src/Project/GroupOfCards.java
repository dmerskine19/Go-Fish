package project;

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards {
    /** ArrayList for Cards.**/
    private ArrayList<Card> cards;
    /** Value of the size of the Group of cards.**/
    private final int size;
    /** Sets the specified size for each of the players hands.
     * @param givenSize - Defines the size of the players starting hand
     **/
    public GroupOfCards(final int givenSize) {
        size = givenSize;
    }
    /** Randomizes the order of the cards.**/
    public void shuffle() {
        Collections.shuffle(cards);
    }
    /** Getter for a specified size.
     * @return - size
     **/
    public int getSize() {
        return size;
    }
    /** Setter for each card to a specific cards with a value and face.
     * @param cards - individual value and suit for the cards in the array list
     **/
    public void setCards(final ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean checkCards(final ArrayList<Card> cards, String s, int v) {
        for (Card card : cards){
            if(card.getSuit().equals(s) && card.getValue() == v) {
                return true;
            }
        }
        return false;
    }
}
