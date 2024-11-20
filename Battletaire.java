/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package group7.battletaire;

/**
 *
 * @author johnm
 */
public class Battletaire {

    public static void main(String[] args) {
        Card testCard = new Card(Card.Value.SEVEN, Card.Suit.DIAMONDS);
        Card testCard2 = new Card();
        System.out.println(testCard.toString());
        System.out.println(testCard2.toString());
    }

    
public static boolean checkMove(Card Card1, Card Card2) //Checks if Card1 can be moved on to Card2
    {
        if((Card1.suit==Card.Suit.DIAMONDS || Card1.suit==Card.Suit.HEARTS) 
                && (Card2.suit==Card.Suit.DIAMONDS || Card2.suit==Card.Suit.HEARTS))
           return false;
     
        if((Card1.suit==Card.Suit.CLUBS || Card1.suit==Card.Suit.SPADES) 
                && (Card2.suit==Card.Suit.CLUBS || Card2.suit==Card.Suit.SPADES))
           return false;
        if(Card1.value==Card.Value.ACE)
            return false;
        
        if(Card1.value.ordinal()+1==Card2.value.ordinal())
            return true;
        return false;
    } // Author: Aidan

    public static boolean checkFoundations(Card Card1, Card Card2) //Checks if Card1 can be moved up to Card2 in a foundation
    {
        if(Card1.suit==Card2.suit && Card2.value.ordinal()+1==Card1.value.ordinal())
            return true;
        return false;
    } // Author: Aidan

    
}
