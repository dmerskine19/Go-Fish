import java.util.ArrayList;

public class NewGroupOfCards extends GroupOfCards {
    /** ArrayList containing new cards being added to the deck. **/
    private final ArrayList<Card> cardsNew = new ArrayList<>();
    /** Function to define the size of a group of cards.
     * @param size - Max size of the new group of cards
     * **/
    public NewGroupOfCards(final int size) {
        super(size);
    }
    /** calls set cards to shuffle cards, randomizing the set.**/
    public void shuffle() {
        super.setCards(cardsNew);
    }

    /** @return the set of newly generated cards.**/
    public ArrayList<Card> generateCards() {
        for (CardGoFish.Suits s: CardGoFish.Suits.values()) {
            for (CardGoFish.Values v : CardGoFish.Values.values()) {
            CardGoFish card = new CardGoFish(s, v);
                cardsNew.add(card);
            }
        }
        return cardsNew;
    }
}
