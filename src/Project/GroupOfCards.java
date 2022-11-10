package Project;
import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards 
{
    private ArrayList <Card> cards;
    private final int size;
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
}
