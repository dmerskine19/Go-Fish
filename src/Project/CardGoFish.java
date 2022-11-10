package Project;
import java.util.Arrays;

public class CardGoFish extends Card {
    public enum Values{
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        Joker,
    }
    public enum Suits{
        Clubs,
        Spades,
        Diamonds,
        Hearts,
    }


    public String toString() {
        return Arrays.toString(Suits.values());
    }

    public CardGoFish(Suits s,Values v){
        super.setSuit(s.toString());
        super.setValue(v.ordinal()+1);
    }
}
