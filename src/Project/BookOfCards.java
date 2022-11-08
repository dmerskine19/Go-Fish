
package project;

import java.util.ArrayList;

//this class is to track the books of card that are formed during game
public class BookOfCards {

    private int bookCount;
    
     public BookOfCards() {
        this.bookCount = 0;
    }

    public void addBookCount() {
        this.bookCount += 1;
    }

    public int countBook() {
        return this.bookCount;
    }

    //to check if a book of four is formed in the hand
    public static boolean checkIfBookInHand(ArrayList<Card> currentHand) {
        boolean bookPresent = false;
        int counter = 1;
        for (int i = 0; i < currentHand.size(); i++) {

            for (int j = i + 1; j < currentHand.size(); j++) {

                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                    //System.out.println("Counter = " + counter);
                }

                if (counter == 4) {
                    bookPresent = true;
                    System.out.println("Book of 4 found");
                    break;
                }
            }
            counter = 1;

        }

        return bookPresent;
    }

    //to return the book of cards  if formed
    public static ArrayList<Card> findBookInHand(ArrayList<Card> currentHand) {
        ArrayList<Card> book = new ArrayList<Card>();
        boolean bookPresent = false;
        int counter = 1;
        int foundPos = 0;

        for (int i = 0; i < currentHand.size(); i++) {

            for (int j = i + 1; j < currentHand.size(); j++) {

                if (currentHand.get(i).getValue() == currentHand.get(j).getValue()) {
                    ++counter;
                }

                if (counter == 4) {
                    bookPresent = true;
                    foundPos = j;
                    System.out.println("Book of 4 found");
                    break;
                } 
                           
            }
            counter = 1;
        }

        for (int k = 0; k < currentHand.size(); k++) {
            if (currentHand.get(k).getValue() == currentHand.get(foundPos).getValue()) {
                book.add(currentHand.get(k));
            }

        }

        return book;

    }

}
