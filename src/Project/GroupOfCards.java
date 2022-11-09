

package project;

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards 
{
   

    private ArrayList <Card> cards;
    private int size;
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }

    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }


    public void setSize(int givenSize) {
        size = givenSize;
    }
   
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
}
