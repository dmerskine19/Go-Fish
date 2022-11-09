package project;
import java.util.ArrayList;
import java.util.Collections;


public class NewGroupOfCards extends GroupOfCards{

    private ArrayList <Card> cardsnew = new ArrayList <Card>();
    private int size;//the size of the grouping
    
    
    public NewGroupOfCards(int givenSize)
    {
        super(givenSize);
    }
    public void shuffle(){
        super.setCards(cardsnew);
        super.shuffle();
    }
    

    public ArrayList <Card> generateCards(){
               
        for(CardGoFish.Suits s: CardGoFish.Suits.values()){
                 
            for(CardGoFish.Values v : CardGoFish.Values.values()){
            CardGoFish card = new CardGoFish(s,v);
                cardsnew.add(card);
            }
        }
        return cardsnew;
    }
}
