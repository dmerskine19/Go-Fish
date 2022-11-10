package Project;
import java.util.ArrayList;

public class NewGroupOfCards extends GroupOfCards{
    private final ArrayList <Card> cardsNew = new ArrayList<>();
    public NewGroupOfCards(int size)
    {
        super(size);
    }
    public void shuffle(){
        super.setCards(cardsNew);
        super.shuffle();
    }
    

    public ArrayList <Card> generateCards(){
        for(CardGoFish.Suits s: CardGoFish.Suits.values()){
            for(CardGoFish.Values v : CardGoFish.Values.values()){
            CardGoFish card = new CardGoFish(s,v);
                cardsNew.add(card);
            }
        }
        return cardsNew;
    }
}
