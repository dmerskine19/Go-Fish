package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static project.SetOfCards.checkIfSetInHand;

class NLRTests {
    @Test
    public void req1() {
        GoFish game = new GoFish();
        game.setNumPlayer(1);
        game.setNumPlayer(2);
    }

    @Test
    public void req2() {
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

        int result2 = ret.size();
        int expResult2 = 7;

        assertEquals(expResult2, result2);

        printHand(ret);

    }
    @Test
    public void req3() {
    }

    @Test
    public void req4() {
        System.out.println("addBookCount");
        SetOfCards instance = new SetOfCards();
        instance.addSetCount();
        int expResult = 1;
        int result = instance.countSet();
        assertEquals(expResult, result);
    }

    @Test
    public void req5() {
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

    @Test
    public void req6() {
        GoFishHand instance = new GoFishHand(7);
        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();

        ArrayList<Card> ret = instance.generateHand(cardHandTemp);
        ArrayList<Card> ret2 =  ret;
        CardGoFish c1 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.King);
        ret.add(c1);
        GoFish.askCard(13, ret);
        assertEquals(ret, ret2);
    }
    @Test
    public void req7() {
        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        GoFishHand instance = new GoFishHand(7);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();

        ArrayList<Card> ret = instance.generateHand(cardHandTemp);
        ArrayList<Card> ret2 = instance.generateHand(cardHandTemp);
        CardGoFish c1 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.King);
        ret.add(c1);
        ret2 = GoFish.askCard(13, ret);
        boolean work = instance.checkCards(ret2,"Clubs", 13);
        assertEquals(work, true);
    }

    @Test
    public void req8() {
        System.out.println("addBookCount");
        SetOfCards instance = new SetOfCards();
        instance.addSetCount();
        int expResult = 1;
        int result = instance.countSet();
        assertEquals(expResult, result);


    }

    @Test
    public void req88() {
        System.out.println("checkIfBookInHand");

        CardGoFish c1 = new CardGoFish(CardGoFish.Suits.Hearts, CardGoFish.Values.Two);
        CardGoFish c2 = new CardGoFish(CardGoFish.Suits.Diamonds, CardGoFish.Values.Two);
        CardGoFish c3 = new CardGoFish(CardGoFish.Suits.Spades, CardGoFish.Values.Two);
        CardGoFish c4 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Two);
        CardGoFish c5 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.King);
        CardGoFish c6 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Six);
        CardGoFish c7 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Eight);

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
    public void req9() {

        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();

        ArrayList<Card> newGrp2  = new ArrayList<Card>();
        CardGoFish card1 = new CardGoFish(CardGoFish.Suits.Hearts, CardGoFish.Values.Ace);
        CardGoFish card2 = new CardGoFish(CardGoFish.Suits.Diamonds, CardGoFish.Values.Ace);
        CardGoFish card3 = new CardGoFish(CardGoFish.Suits.Spades, CardGoFish.Values.Ace);
        CardGoFish card4 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Ace);
        cardHandTemp.remove(card4);
        cardHandTemp.remove(card4);
        cardHandTemp.remove(card4);
        cardHandTemp.remove(card4);
        newGrp2.add(card4);
        newGrp2.add(card3);
        newGrp2.add(card2);
        newGrp2.add(card1);
        checkIfSetInHand(newGrp2);
        boolean expResult = true;
        boolean result = checkIfSetInHand(newGrp.generateCards());;

        assertEquals(expResult, result);
    }

    @Test
    public void req10() {
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
    public void req11() {
        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> cardHandTemp = newGrp.generateCards();
        Card ret = GoFishHand.rdmCardFromHand(cardHandTemp);
        int i = 0;
        if(cardHandTemp.size() > i) {
            cardHandTemp.remove(ret);
        }

    }



    private void printHand(ArrayList<Card> ret) {
        System.out.println("Your Hand:" + " (" + ret.size() + ")");
        for (Card card : ret) {
            System.out.print(card.getSuit() + " " + card.getValue() + " | ");
        }
        System.out.println();
    }
}

