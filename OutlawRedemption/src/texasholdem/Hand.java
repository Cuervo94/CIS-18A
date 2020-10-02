/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;

/**
 *
 * @author cbran
 */
public class Hand {

    private final ArrayList<Card> hand = new ArrayList();

    public Integer size() {
        return hand.size();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card getCard(int num) {
        return hand.get(num);
    }

    public String handToString() {
        String h = "";
        for (int i = 0; i < this.size(); i++) {
            if (i == hand.size() - 1) {
                h += this.getCard(i).cardToString();
            } else {
                h += this.getCard(i).cardToString() + "\n";
            }
        }
        return h;
    }

    public void displayHand() {
        for (Card card : hand) {
            System.out.println(card.cardToString());
        }
    }
}
