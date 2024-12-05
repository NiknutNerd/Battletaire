package group7.battletaire;

public class Card {
    public enum Value {
	    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public enum Suit {
	    SPADES, CLUBS, DIAMONDS, HEARTS
    }
        
    public Value value;
    public Suit suit;
    public boolean faceUp;
        
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
        //True is red, False is black
        return (suit != Suit.SPADES) && (suit != Suit.CLUBS);
    }
    
    public String toString() {
        return value + " of " + suit + " FaceUp(): " + faceUp;
    }
}