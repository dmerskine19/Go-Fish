package project;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GameTest {
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
}
