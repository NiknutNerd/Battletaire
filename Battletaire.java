/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package group7.battletaire;

import java.util.*;

public class Battletaire {

    public static void main(String[] args) {
        /*Card testCard = new Card(Card.Value.SEVEN, Card.Suit.DIAMONDS);
        Card testCard2 = new Card();
        System.out.println(testCard.toString());
        System.out.println(testCard2.toString());*/
        Card[] deck;
        deck = new Card[52];
        createDeck(deck);
        Stack<Card>[] piles = new Stack[7];
        Stack<Card>[] foundations = new Stack[4];
        Stack<Card> stock = new Stack<>();
        Stack<Card> dump = new Stack<>();
        Stack<Card> extra = new Stack<>();
        
        for (int i = 0; i < 7; i++) 
            piles[i] = new Stack<>();
        for (int i = 0; i < 4; i++) 
            foundations[i] = new Stack<>();
        
        setField(deck, piles, stock);
        new GameBoard(new Battletaire(), piles, foundations, stock, dump);
        
        for(Card e : deck) {
            System.out.println(e.toString());
        }   
    } // Author: Aidan, John

    
public static boolean checkMove(Card Card1, Card Card2, Stack pile1, Stack pile2) //Checks if Card1 in pile1 can be moved on to Card2 in pile2
    {
        if(pile1.size()!=pile1.indexOf(Card1) || pile2.size()!=pile2.indexOf(Card2))
            return false;
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

    public static boolean checkFoundations(Card Card1, Card Card2, Stack pile) //Checks if Card1 can be moved up to Card2 in a foundation
    {
        if(pile.size()!=pile.indexOf(Card1))
            return false;
        if(Card1.suit==Card2.suit && Card2.value.ordinal()+1==Card1.value.ordinal())
            return true;
        return false;
    } // Author: Aidan

public static void createDeck( Card[] deck)
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
        deck[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.KING,Card.Suit.SPADES);
        k++;
        deck[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.KING,Card.Suit.CLUBS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.KING,Card.Suit.DIAMONDS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.ACE,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TWO,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.THREE,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FOUR,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.FIVE,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SIX,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.SEVEN,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.EIGHT,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.NINE,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.TEN,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.JACK,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.QUEEN,Card.Suit.HEARTS);
        k++;
        deck[numbers[k]] = new Card(Card.Value.KING,Card.Suit.HEARTS);     
    } // Author: Aidan

    public static void setField(Card[] deck, Stack[] piles, Stack stock)
    {
        int i=0, j=0, k=0;
        while(j<28)
        {
            while(i<7)
            {
                if(i==k)
                    deck[j].faceUp = true;
                piles[i].push(deck[j]);
                i++;
                j++;
            }
            k++;
            i=0;
        }
        while(j<52)
        {
            stock.push(deck[j]);
            j++;
        }
    } //author: Aidan


    public static void moveCard(Card Card1, Card Card2, Stack pile1, Stack pile2, Stack extra)
    {
        int i=0;
        if(checkMove(Card1, Card2, pile1, pile2))
        {
            while(i<pile1.indexOf(Card1))
            {
               extra.push(pile1.pop());
               i++;
            }
            while(i>0)
            {
                pile2.push(extra.pop());
                i--;
            }
        }
    } // author: Aidan

    public static void movetoFoundation(Card Card1, Card Card2, Stack pile, Stack foundation)
    {
        if(checkFoundations(Card1, Card2, pile))
            foundation.push(pile.pop());
    } // author: Aidan

    public static boolean checkVictory(Stack foundation1, Stack foundation2, Stack foundation3, Stack foundation4)
    {
        if(foundation1.size()==13 && foundation2.size()==13 && foundation3.size()==13 && foundation4.size()==13)
            return true;
        return false;
    } // author: Aidan

    public static void checkStock(Stack stock, Stack dump)
    {
        int i=0;
        if(stock.size()>3)
        {
            while(i<3)
            {
                dump.push(stock.pop());
                i++;
            }
        if(stock.size()>0 && stock.size()<3)
        {
            while(i<stock.size())
            {
                dump.push(stock.pop());
                i++;
            }
        }
        if(stock.size()==0)
        {
            while(i<dump.size())
            {
                stock.push(dump.pop());
                i++;
            }
        }
        }
    } // author: Aidan
    
}
