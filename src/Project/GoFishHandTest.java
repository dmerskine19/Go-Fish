
package project;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoFishHandTest {

    public GoFishHandTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of generateHand method, of class GoFishHand.
     */
    @Test
    public void testGenerateHandGood() {
        System.out.println("generateHand");
        GoFishHand instance = new GoFishHand(7);
        boolean expResult = true;
        boolean result = false;

        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();

        ArrayList<Card> ret = instance.generateHand(cardHandTemp);
        if (ret.size() == 7)
            result = true;
        else
            result = false;

        assertEquals(expResult, result);

    }


    @Test
    public void testGenerateHandBad() {
        System.out.println("generateHand");
        GoFishHand instance = new GoFishHand(20);
        boolean expResult = false;
        boolean result = false;

        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();

        ArrayList<Card> ret = instance.generateHand(cardHandTemp);
        if (ret.size() == 7)
            result = true;
        else
            result = false;

        assertEquals(expResult, result);

    }


    /**
     * Test of selectRandomCardFromHand method, of class GoFishHand.
     */
    @Test
    public void testSelectRandomCardFromHandGood() {
        System.out.println("selectRandomCardFromHand");

        CardGoFish c1 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.King);
        CardGoFish c2 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Six);
        CardGoFish c3 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Eight);

        ArrayList<Card> currentPlayerHand = new ArrayList<Card>();
        currentPlayerHand.add(c1);
        currentPlayerHand.add(c2);
        currentPlayerHand.add(c3);

        boolean expResult = true;
        boolean result = false;
        Card ret = GoFishHand.rdmCardFromHand(currentPlayerHand);
        if (ret.equals(c1) || ret.equals(c2) || ret.equals(c3))
            result = true;
        else
            result = false;
        assertEquals(expResult, result);

    }

}