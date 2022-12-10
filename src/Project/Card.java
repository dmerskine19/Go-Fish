package project;

public abstract class Card {
    /** this value will be use. **/
    private String suit;
    /** to get the value in suit.**/
    private int value;
    /**  @return to string to get the value**/
    public String getSuit() {
        return suit;
    } /***
     * @param suit
     */
    public void setSuit(String suit) {
        CardGoFish card = new CardGoFish();
        this.suit = suit;
         System.out.println(this.suit);
    }
    /**  @return to int to get the value**/
    public int getValue() {
        return value;
    } /***
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
         System.out.println(this.value);
    }
    @Override
    public abstract String toString();

}

