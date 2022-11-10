package project;

import java.util.Arrays;

public abstract class Card
{
   private String suit;
   private int value;
    

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        
       // CardGoFish card = new CardGoFish();
        this.suit = suit;
        // System.out.println(this.suit);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        // System.out.println(this.value);
    }
    
    @Override
    public abstract String toString();
    
}
