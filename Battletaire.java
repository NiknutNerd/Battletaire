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
}
