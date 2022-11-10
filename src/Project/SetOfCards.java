package Project;

import java.util.ArrayList;

//this class is to track the books of card that are formed during game
public class SetOfCards {

    private int setCount;
    
     public SetOfCards() {
        this.setCount = 0;
    }

    public void addSetCount() {
        this.setCount += 1;
    }

    public int countSet() {
        return this.setCount;
    }

    //to check if a book of four is formed in the hand
    public static boolean checkIfSetInHand(ArrayList<Card> currentHand) {
        boolean setPresent = false;
        int counter = 1;
        for (int i = 0; i < currentHand.size(); i++) {

            for (int j = i + 1; j < currentHand.size(); j++) {

                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                    //System.out.println("Counter = " + counter);
                }

                if (counter == 4) {
                    setPresent = true;
                    System.out.println("Set of 4 found");
                    break;
                }
            }
            counter = 1;

        }

        return setPresent;
    }

    //to return the book of cards  if formed
    public static ArrayList<Card> findSetInHand(ArrayList<Card> currentHand) {
        ArrayList<Card> set = new ArrayList<>();
        int counter = 1;
        int foundPos = 0;

        for (int i = 0; i < currentHand.size(); i++) {
            for (int j = i + 1; j < currentHand.size(); j++) {
                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                }

                if (counter == 4) {
                    foundPos = j;
                    System.out.println("Set of 4 found");
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
