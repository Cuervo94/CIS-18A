/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Comparator;

/**
 *
 * @author cbran
 */
public class Card {

    private final int rank;
    private final int suit;
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};

    Card(int r, int s) {
        this.rank = r;
        this.suit = s;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public static String rankAsString(int rank) {
        return ranks[rank];
    }

    public static String suitAsString(int suit) {
        return suits[suit];
    }

    public String cardToString() {
        return ranks[rank] + " of " + suits[suit];
    }

    public static boolean sameCard(Card card1, Card card2) {
        return (card1.rank == card2.rank && card1.suit == card2.suit);
    }
}

class rankComparator implements Comparator<Object> {

    @Override
    public int compare(Object card1, Object card2) throws ClassCastException {
        if (!((card1 instanceof Card) && (card2 instanceof Card))) {
            throw new ClassCastException("A Card object was expected.  Parameter 1 class: " + card1.getClass()
                    + " Parameter 2 class: " + card2.getClass());
        }
        int rank1 = ((Card) card1).getRank();
        int rank2 = ((Card) card2).getRank();
        return rank1 - rank2;
    }
}

class suitComparator implements Comparator<Object> {

    @Override
    public int compare(Object card1, Object card2) throws ClassCastException {
        if (!((card1 instanceof Card) && (card2 instanceof Card))) {
            throw new ClassCastException("A Card object was expected.  Parameter 1 class: " + card1.getClass()
                    + " Parameter 2 class: " + card2.getClass());
        }
        int suit1 = ((Card) card1).getSuit();
        int suit2 = ((Card) card2).getSuit();
        return suit1 - suit2;
    }
}
