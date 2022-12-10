package project;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

public class CardGoFish extends Card {
    /** go fish value .**/
    public CardGoFish() {
    }

    public enum Values {
        /** Value 13. **/
        King,
        /** Value 12. **/
        Queen,
        /** Value 11. **/
        Jack,
        /** Value 10. **/
        Ten,
        /** Value 9. **/
        Nine,
        /** Value 8. **/
        Eight,
        /** Value 7. **/
        Seven,
        /** Value 6. **/
        Six,
        /** Value 5. **/
        Five,
        /** Value 4. **/
        Four,
        /** Value 3. **/
        Three,
        /** Value 2. **/
        Two,
        /** Value 1. **/
        Ace,
    }

    public enum Suits {
        /** The suit, Clubs in the deck. **/
        Clubs,
        /** The suit, Diamonds in the deck. **/
        Diamonds,
        /** The suit, Spades in the deck. **/
        Spades,
        /** The suit, Hearts in the deck. **/
        Hearts,
    }

    /** @return the suits as a string. **/
    public String toString() {
        return Arrays.toString(Suits.values());
    }
    /**
     * A constructor to generate cards with a suits.
     * @param s - Suit
     * @param v - Value
     **/
    public CardGoFish(final @NotNull Suits s, final @NotNull Values v) {
        super.setSuit(s.toString());
        super.setValue(v.ordinal() + 1);

}
}