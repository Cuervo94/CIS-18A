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
public class Table {

    private final ArrayList<Card> community;
    private final ArrayList<Card> burn;

    Table() {
        community = new ArrayList();
        burn = new ArrayList();
    }

    public void addCommunityCard(Card card) {
        this.community.add(card);
    }

    public Card getCommunityCard(int num) {
        return this.community.get(num);
    }

    public void addBurnCard(Card card) {
        this.burn.add(card);
    }

    public Card getBurnCard(int num) {
        return this.burn.get(num);
    }

    public int size() {
        return community.size();
    }

    public String communityToString() {
        String c = "";
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                c += (this.getCommunityCard(i).cardToString());
            } else {
                c += (this.getCommunityCard(i).cardToString() + "\n");
            }

        }
        return c;
    }

    public void displayCommunity() {
        for (Card card : community) {
            System.out.println(card.cardToString());
        }
    }
}
