/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cbran
 */
public class Deck {

    private ArrayList<Card> deck = new ArrayList();
    private Random random;

    Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(j, i));
            }
        }
    }

    public Integer size() {
        return deck.size();
    }

    public Card drawCard(int i) {
        return deck.get(i);
    }

    public void shuffle() {
        random = new Random();
        for (int i = size(); i > 1; i--) {
            swap(deck, i - 1, random.nextInt(i));
        }
    }

    private void swap(ArrayList<Card> deck, int i, int j) {
        Card temp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, temp);
    }

    public void cut() {
        Deck temp = new Deck();
        Random rand = new Random();
        int cut = rand.nextInt(52);
        for (int i = 0; i < cut; i++) {
            temp.deck.set(i, this.deck.get(52 - cut + i));
        }
        for (int j = 0; j < 52 - cut; j++) {
            temp.deck.set(j + cut, this.deck.get(j));
        }
        this.deck = temp.deck;
    }

    public String deckToString() {
        String d = "";
        for (int i = 0; i < this.size(); i++) {
            if (i == deck.size() - 1) {
                d += deck.get(i).cardToString();
            } else {
                d += deck.get(i).cardToString() + "\n";
            }
        }
        return d;
    }

    public void displayDeck() {
        for (Card card : deck) {
            System.out.println(card.cardToString());
        }
    }
}
