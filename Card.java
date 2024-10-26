/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group7.battletaire;

import java.awt.Point;

/**
 *
 * @author johnm
 */
public class Card {
    public static enum Value {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public static enum Suit {
	SPADES, CLUBS, DIAMONDS, HEARTS
    }
        
    private Value value;
    private Suit suit;
    private boolean faceUp;
    private Point location;
    private int x;
    private int y;
        
    Card() {
        value = Card.Value.ACE;
        suit = Card.Suit.SPADES;
        location = new Point(0, 0);
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
    
    public boolean getFaceUp() {
        return faceUp;
    }
    
    public String toString() {
        return value + " of " + suit + " is at " + location + " " + faceUp;
    }
}
