package project;

import java.util.ArrayList;

//this class is to track the books of card that are formed during game
public class SetOfCards {
    /** Value that represents the number of sets a player has made. **/
    private int setCount;
    /** Setter for the Value of sets a player has made. **/
    public SetOfCards() {
        this.setCount = 0;
    }
    /** This increments the number of sets a player has made. **/
    public void addSetCount() {
        this.setCount += 1;
    }

    /** @return setCount - the number of sets a player has made. **/
    public int countSet() {
        return this.setCount;
    }
    /** to check if a book of four is formed in the hand.
     * @return a set if there is one present in the players hand
     * @param currentHand - The Array of the players current hand
     **/
    public static boolean checkIfSetInHand(final ArrayList<Card> currentHand) {
        boolean setPresent = false;
        int counter = 1;
        final int sizeOfSet = 4;
        for (int i = 0; i < currentHand.size(); i++) {

            for (int j = i + 1; j < currentHand.size(); j++) {

                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                    //System.out.println("Counter = " + counter);
                }

                if (counter == sizeOfSet) {
                    setPresent = true;
                    break;
                }
            }
            counter = 1;

        }

        return setPresent;
    }
    /** to return the book of cards  if formed.
     * @return checks if there is a set present in the players hand
     * @param currentHand - The Array of the players current hand
     **/
    public static ArrayList<Card> findSetInHand(final ArrayList<Card> currentHand) {
        ArrayList<Card> set = new ArrayList<>();
        int counter = 1;
        int foundPos = 0;
        final int sizeOfSet = 4;

        for (int i = 0; i < currentHand.size(); i++) {
            for (int j = i + 1; j < currentHand.size(); j++) {
                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                }

                if (counter == sizeOfSet) {
                    foundPos = j;
                    break;
                }
            }
            counter = 1;
        }

        for (Card card : currentHand) {
            if (card.getValue() == currentHand.get(foundPos).getValue()) {
                set.add(card);
            }

        }

        return set;
    }
}
