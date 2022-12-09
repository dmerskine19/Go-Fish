package project;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static project.SetOfCards.checkIfSetInHand;

public class UnitTest {
    Random rand = new Random();
    @org.junit.Test
    public void testPlayerStatic(){
        Player.setPlayerID("Nhi Nguyen");
        assertEquals("Nhi Nguyen", Player.getPlayerID());
        assertNotEquals("Jaiden", Player.getPlayerID());
        Player.setPlayerID("Nhi Nguyen");
        assertNotEquals("Jaiden", Player.getPlayerID());

    }
    @org.junit.Test
    public void testPlayerConstruct(){
        Player.setPlayerID("");
        Player NhiNguyen = new Player("Nhi Nguyen");
        assertEquals("Nhi Nguyen",Player.getPlayerID());
    }

    @org.junit.Test
    public void testSetCard(){
        SetOfCards setCard = new SetOfCards();
        assertEquals(0,setCard.countSet());
        setCard.addSetCount();
        assertEquals(1,setCard.countSet());
        int a  = rand.nextInt(100);
        for(int i=0;i<a;i++){
            setCard.addSetCount();
            assertEquals(i+2,setCard.countSet());
        }
    }
    @org.junit.Test
    public void testGroupOfCards(){
        GroupOfCards group = new GroupOfCards(10);
        assertEquals(10,group.getSize());
    }
    @org.junit.Test
    public void testNewPlayer(){
        NewPlayer a = new NewPlayer("OK");
        assertEquals("OK",Player.getPlayerID());
    }

    @org.junit.Test
    public void testMaxCardsInHand(){
        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        ArrayList<Card> currentHand = newGrp.generateCards();
        int expResult = 52;
        int result = currentHand.size();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testGame() throws Exception {

        //Play a whole game with a smaller deck that only has 5 values. If code crashes, test fails.
        ArrayList<Card> newGrp  = new ArrayList<Card>();
        CardGoFish card1 = new CardGoFish(CardGoFish.Suits.Hearts, CardGoFish.Values.Ace);
        CardGoFish card2 = new CardGoFish(CardGoFish.Suits.Diamonds, CardGoFish.Values.Ace);
        CardGoFish card3 = new CardGoFish(CardGoFish.Suits.Spades, CardGoFish.Values.Ace);
        CardGoFish card4 = new CardGoFish(CardGoFish.Suits.Clubs, CardGoFish.Values.Ace);
        newGrp.add(card4);
        newGrp.add(card3);
        newGrp.add(card2);
        newGrp.add(card1);
        checkIfSetInHand(newGrp);
        boolean expResult = true;
        boolean result = checkIfSetInHand(newGrp);;
        assertEquals(expResult, result);

    }
}
