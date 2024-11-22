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
        /*Card testCard = new Card(Card.Value.SEVEN, Card.Suit.DIAMONDS);
        Card testCard2 = new Card();
        System.out.println(testCard.toString());
        System.out.println(testCard2.toString());*/
        Card[] card;
        card = new Card[52];
        createDeck(card);
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

public static void createDeck( Card[] card) // Creates randomly ordered deck
    {   
        Random r = new Random();
          int n = 52, k = 0;
          int[] numbers;
          numbers = new int[n];
          while(k<n)
          {
              numbers[k] = k;
              k++;
          }
        for (int i = n-1; i > 0; i--) 
        {
            int j = r.nextInt(i);
              
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        k=0;
        card[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.KING,Card.Suit.SPADES);
        k++;
        card[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.KING,Card.Suit.CLUBS);
        k++;
        card[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.KING,Card.Suit.DIAMONDS);
        k++;
        card[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.HEARTS);
        k++;
        card[numbers[k]] = new Card(Card.Value.KING,Card.Suit.HEARTS);     
    } // Author: Aidan
    
    
}
