/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author lvsho
 */
public class ShuffleCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code applicatiosn logic here
        String[] suits = {"H", "D", "C", "S"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Vector<String> deck = new Vector<>(52);
        LinkedList<String> shuffledDeck = new LinkedList<>();
        for (String s : suits) {
            for (String n : numbers) {
                deck.add(n + s);
            }
        }
        //Shuffle the deck
        Random r = new Random();
        while (!deck.isEmpty()) {
            int chooseIndex = r.nextInt(deck.size());
            shuffledDeck.add(deck.get(chooseIndex));
            deck.remove(chooseIndex);
        }
        
        StringBuffer[] hands = {new StringBuffer("Hand 1:"), new StringBuffer("Hand 2:"), new StringBuffer("Hand 3:"), new StringBuffer("Hand 4:")};
        ListIterator<String> cards = shuffledDeck.listIterator();
        //Deal cards
        while (cards.hasNext()) {
            for (StringBuffer hand : hands) {
                hand.append(" ").append(cards.next());
            }
        }
        //Print out result
        for (StringBuffer hand : hands) {
            System.out.println(hand);
        }

    }

}
