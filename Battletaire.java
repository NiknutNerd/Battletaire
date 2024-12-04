package group7.battletaire;

import java.util.*;

public class Battletaire {
    private static Stack<Card>[] piles = new Stack[7];
    private static Stack<Card>[] foundations = new Stack[4];
    private static Stack<Card> stock = new Stack<>();
    private static Stack<Card> dump = new Stack<>();
    private static Stack<Card> extra = new Stack<>();
    private static Card selectedCard = null;
    private static Stack<Card> selectedSource = null;
    private static GameBoard board;
    
    public static void main(String[] args) {
        /*Card testCard = new Card(Card.Value.SEVEN, Card.Suit.DIAMONDS);
        Card testCard2 = new Card();
        System.out.println(testCard.toString());
        System.out.println(testCard2.toString());*/
        Battletaire game = new Battletaire();
        
        Card[] deck;
        deck = new Card[52];
        createDeck(deck);
        
        for (int i = 0; i < 7; i++) 
            piles[i] = new Stack<>();
        for (int i = 0; i < 4; i++) 
            foundations[i] = new Stack<>();
        
        setField(deck, piles, stock);
        board = new GameBoard(game, piles, foundations, stock, dump);
        
        for(Card e : deck) {
            System.out.println(e.toString());
        }   
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

        int dealt = 0;
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Value val : Card.Value.values()){
                deck[numbers[dealt]] = new Card(val, suit);
                dealt++;
            }
        }
    } // Author: Aidan, Nikki

    public static void setField(Card[] deck, Stack[] piles, Stack stock)
    {
        int cardsDealt = 0;
        for(int col = 0; col < 7; col++){
            for(int row = 0; row <= col; row++){
                if(row == col){
                    deck[cardsDealt].faceUp = true;
                }
                piles[col].push(deck[cardsDealt]);
                cardsDealt++;
            }
        }
        while(cardsDealt < 52){
            stock.push(deck[cardsDealt]);
            cardsDealt++;
        }
    } //author: Aidan, Nikki
    
    public void dealThreeCards()
    {
        for (int i = 0; i < 3; i++)
        {
            if (! stock.isEmpty())
            {
                Card temp = stock.pop();
                dump.push(temp);
                temp.turnUp();
            }
        }
    }
    
    public void resetStock()
    {
        while (!dump.isEmpty())
        {
            Card temp = dump.pop();
            temp.turnDown();
            stock.push(temp);
        }
    }
    
    public void stockClicked() {
        System.out.println("stock clicked");
        board.unselect();
        if (! board.isDumpSelected() && ! board.isPileSelected()) {
            if (stock.isEmpty()) 
                resetStock();
            else 
                dealThreeCards();
        }
    }

    public void dumpClicked() {
        System.out.println("dump clicked");
        if (!dump.isEmpty()) {
            if (!board.isDumpSelected())
                board.selectDump();
            else
                board.unselect();
        }
    }
        
    private boolean canPlaceOnFoundation(Card card, int index) {
        if (foundations[index].isEmpty()) 
            return (card.getRank() == 1);
        Card temp = foundations[index].peek();
        return (temp.getRank() + 1 == card.getRank()) && (temp.getSuit().equals(card.getSuit()));
    }
    
    private boolean canPlaceOnPile(Card card, int index) {
        Stack<Card> pile = piles[index];
        if (pile.isEmpty()) return (card.getRank() == 13);
            Card top = pile.peek();
        if (! top.getFaceUp()) return false;
            return (card.getColor() != top.getColor()) && (card.getRank() == top.getRank() - 1);
    }

    public void foundationClicked(int index) {
		System.out.println("foundation #" + index + " clicked");
        if (board.isDumpSelected())
        {
            if (canPlaceOnFoundation(dump.peek(), index))
            {
                Card temp = dump.pop();
                foundations[index].push(temp);
                board.unselect();
                if(temp.getRank() == 1){
                    boolean toEnd = true;
                    for(int i = 0; i < 4; i++){
                        if (foundations[i].peek().getRank() != 13){
                            //Dont go to end screen
                            toEnd = false;
                            break;
                        }
                    }
                    if(toEnd){
                        board.drawEnd();
                    }
                }
            }
        }
        if (board.isPileSelected())
        {
            Stack<Card> selectedPile = piles[board.selectedPile()];
            if (canPlaceOnFoundation(selectedPile.peek(), index))
            {
                Card temp = selectedPile.pop();
                foundations[index].push(temp);
                if (!selectedPile.isEmpty()) selectedPile.peek().turnUp();
                board.unselect();
                if(temp.getRank() == 13)
                {
                    boolean toEnd = true;
                    for(int i = 0; i < 4; i++){
                        if (foundations[i].peek().getRank() != 13){
                            //Dont go to end screen
                            toEnd = false;
                            break;
                        }
                    }
                    if(toEnd){
                        board.drawEnd();
                    }
                }
            }
        }
    }

    public void pileClicked(int index) {
        System.out.println("pile #" + index + " clicked");
        if (board.isDumpSelected()) {
            Card temp = dump.peek();
            if (canPlaceOnPile(temp, index))
            {
                piles[index].push(dump.pop());
                piles[index].peek().turnUp();
            }
            board.unselect();
            board.selectPile(index);
        }
        else if (board.isPileSelected())
        {
            int oldPile = board.selectedPile();
            if (index != oldPile)
            {
                Stack<Card> temp = removeFaceUpCards(oldPile);
                if (canPlaceOnPile(temp.peek(), index))
                {
                    addToPile(temp, index);if (!piles[oldPile].isEmpty()) piles[oldPile].peek().turnUp();

                    board.unselect();
                }
                else
                {
                    addToPile(temp, oldPile);
                    board.unselect();
                    board.selectPile(index);
                }
            }
            else board.unselect();
        }
        else
        {
            board.selectPile(index);
            piles[index].peek().turnUp();
        }
    }
    
    private void addToPile(Stack<Card> cards, int index)
    {
        while (!cards.isEmpty())
        {
            piles[index].push(cards.pop());
        }
    }
    
    private Stack<Card> removeFaceUpCards(int index)
    {
        Stack<Card> cards = new Stack<Card>();
        while (! piles[index].isEmpty() && piles[index].peek().getFaceUp())
        {
            cards.push(piles[index].pop());
        }
        return cards;
    }

    //Large amount of unused functions
    @Deprecated
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

    @Deprecated
    public static void moveCard(Card card, Stack<Card> fromPile, Stack<Card> toPile) {
        Stack<Card> temp = new Stack<>();
        while (!fromPile.isEmpty() && fromPile.peek().equals(card)) {
            temp.push(fromPile.pop());
        }
        if (!temp.isEmpty() && checkMove(temp.peek(), toPile.peek(), fromPile, toPile)) {
            while (!temp.isEmpty()) {
                toPile.push(temp.pop());
            }
        } else {
            while (!temp.isEmpty()) {
                fromPile.push(temp.pop());
            }
        }
    }// author: Aidan, John

    @Deprecated
    public static void movetoFoundation(Card Card1, Card Card2, Stack pile, Stack foundation)
    {
        if(checkFoundations(Card1, Card2, pile))
            foundation.push(pile.pop());
    } // author: Aidan

    @Deprecated
    public static boolean checkVictory(Stack foundation1, Stack foundation2, Stack foundation3, Stack foundation4)
    {
        if(foundation1.size()==13 && foundation2.size()==13 && foundation3.size()==13 && foundation4.size()==13)
            return true;
        return false;
    } // author: Aidan

    @Deprecated
    public static void checkStock(Stack<Card> stock, Stack<Card> dump) {
        if (stock.isEmpty()) {
            while (!dump.isEmpty()) {
                stock.push(dump.pop());
            }
        } else {
            for (int i = 0; i < 3 && !stock.isEmpty(); i++) {
                dump.push(stock.pop());
            }
        }
    } // author: Aidan, John

    @Deprecated
    private void removeSelectedCardFromSource() {
        if (selectedSource != null) {
            selectedSource.pop(); // Remove the card from its source stack
        }
    }

    @Deprecated
    private void moveCardToPile(Card card, Stack<Card> pile) {
        Stack<Card> tempStack = new Stack<>();
        while (!selectedSource.isEmpty() && selectedSource.peek() != card) {
            tempStack.push(selectedSource.pop());
        }
        if (!selectedSource.isEmpty()) {
            tempStack.push(selectedSource.pop());
        }
        while (!tempStack.isEmpty()) {
            pile.push(tempStack.pop());
        }
    }

    @Deprecated
    private Card selectGroupOfCards(Stack<Card> pile, int index) {
        Stack<Card> tempStack = new Stack<>();
        Card topCard = pile.peek();

        while (!pile.isEmpty() && isPartOfDescendingSequence(pile.peek(), topCard)) {
            tempStack.push(pile.pop());
        }
        while (!tempStack.isEmpty()) {
            pile.push(tempStack.pop());
        }
        return topCard;
    }

    @Deprecated
    private boolean isPartOfDescendingSequence(Card card, Card topCard) {
        return card.getRank() == topCard.getRank() - 1 && card.getColor() != topCard.getColor();
    }

}
