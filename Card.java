package group7.battletaire;

import java.awt.Point;

public class Card {
    public static enum Value {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public static enum Suit {
	SPADES, CLUBS, DIAMONDS, HEARTS
    }
        
    public Value value;
    public Suit suit;
    public boolean faceUp;
    private int x;
    private int y;
        
    Card() {
        value = Card.Value.ACE;
        suit = Card.Suit.SPADES;
        faceUp = false;
    }
    
    Card(Value v, Suit s) {
        value = v;
        suit = s;
        faceUp = false;
    }
    
    public Value getValue() {
        return value;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public int getRank() {
        return value.ordinal() + 1; // Assuming Ace is 1, etc.
    }
    
    public boolean getFaceUp() {
        return faceUp;
    }
    
    public void turnUp() {
        faceUp = true;
    }

    public void turnDown() {
        faceUp = false;
    }
    
    public boolean getColor() {
        if((suit == Card.Suit.SPADES) || (suit == Card.Suit.CLUBS))
            return false;
        else
            return true;
    }
    
    public String toString() {
        return value + " of " + suit + " FaceUp(): " + faceUp;
    }
}
