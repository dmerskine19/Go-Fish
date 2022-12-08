package project;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import project.CardGoFish.Suits;
import project.CardGoFish.Values;


public class SetOfCardsTest {

    public SetOfCardsTest() {
    }



    /**
     * Test of addBookCount method, of class BookOfCards.
     */
    @Test
    public void testAddBookCountGood() {
        System.out.println("addBookCount");
        SetOfCards instance = new SetOfCards();
        instance.addSetCount();
        int expResult = 1;
        int result = instance.countSet();
        assertEquals(expResult, result);

    }

    /**
     * Test of countBook method, of class BookOfCards.
     */
    @Test
    public void testCountBookGood() {
        System.out.println("countBook");
        SetOfCards instance = new SetOfCards();
        int expResult = 0;
        int result = instance.countSet();
        assertEquals(expResult, result);

    }



    /**
     * Test of checkIfBookInHand method, of class BookOfCards.
     */
    @Test
    public void testCheckIfBookInHandGood() {
        System.out.println("checkIfBookInHand");

        CardGoFish c1 = new CardGoFish(Suits.Hearts, Values.Two);
        CardGoFish c2 = new CardGoFish(Suits.Diamonds, Values.Two);
        CardGoFish c3 = new CardGoFish(Suits.Spades, Values.Two);
        CardGoFish c4 = new CardGoFish(Suits.Clubs, Values.Two);
        CardGoFish c5 = new CardGoFish(Suits.Clubs, Values.King);
        CardGoFish c6 = new CardGoFish(Suits.Clubs, Values.Six);
        CardGoFish c7 = new CardGoFish(Suits.Clubs, Values.Eight);

        ArrayList<Card> currentHand = new ArrayList<Card>();
        currentHand.add(c1);
        currentHand.add(c2);
        currentHand.add(c3);
        currentHand.add(c4);
        currentHand.add(c5);
        currentHand.add(c6);
        currentHand.add(c7);

        boolean expResult = true;
        boolean result = SetOfCards.checkIfSetInHand(currentHand);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckIfBookInHandBad() {
        System.out.println("checkIfBookInHand");

        CardGoFish c1 = new CardGoFish(Suits.Hearts, Values.Two);
        CardGoFish c2 = new CardGoFish(Suits.Diamonds, Values.Two);
        CardGoFish c3 = new CardGoFish(Suits.Spades, Values.Three);
        CardGoFish c4 = new CardGoFish(Suits.Clubs, Values.Two);
        CardGoFish c5 = new CardGoFish(Suits.Clubs, Values.King);
        CardGoFish c6 = new CardGoFish(Suits.Clubs, Values.Six);
        CardGoFish c7 = new CardGoFish(Suits.Clubs, Values.Eight);

        ArrayList<Card> currentHand = new ArrayList<Card>();
        currentHand.add(c1);
        currentHand.add(c2);
        currentHand.add(c3);
        currentHand.add(c4);
        currentHand.add(c5);
        currentHand.add(c6);
        currentHand.add(c7);

        boolean expResult = false;
        boolean result = SetOfCards.checkIfSetInHand(currentHand);
        assertEquals(expResult, result);
    }
}
