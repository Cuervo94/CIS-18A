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
public class HandValue {

    private final ArrayList<Card> allCards = new ArrayList();
    private final static short ONE = 1;
    private final static short TWO = 2;
    private final static short THREE = 3;
    private final static short FOUR = 4;

    public int size() {
        return allCards.size();
    }

    public void addCard(Card card) {
        allCards.add(card);
    }

    public Card getCard(int i) {
        return allCards.get(i);
    }

    public void sortByRank() {
        allCards.sort(new rankComparator());
    }

    public void sortBySuit() {
        allCards.sort(new suitComparator());
    }

    public void sortBySuitThenRank() {
        sortBySuit();
        sortByRank();
    }

    public void sortByRankThenSuit() {
        sortByRank();
        sortBySuit();
    }

    public ArrayList<String> evaluateHand() {
        ArrayList<String> handResult;
        int[] rankCounter = new int[13];
        int[] suitCounter = new int[4];

        for (int i = 0; i < rankCounter.length; i++) {
            rankCounter[i] = 0;
        }
        for (int i = 0; i < suitCounter.length; i++) {
            suitCounter[i] = 0;
        }
        for (Card card : allCards) {
            rankCounter[card.getRank()]++;
            suitCounter[card.getSuit()]++;
        }
        this.sortByRankThenSuit();
        handResult = evaluateRoyal(rankCounter, suitCounter);
        if (handResult.isEmpty()) {
            handResult = evaluateStraightFlush(rankCounter, suitCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateFourOfAKind(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateFullHouse(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateFlush(rankCounter, suitCounter);
        }
        if (handResult.isEmpty()) {
            this.sortByRank();
            handResult = evaluateStraight(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateThreeOfAKind(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateTwoPair(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateOnePair(rankCounter);
        }
        if (handResult.isEmpty()) {
            handResult = evaluateHighCard(rankCounter);
        }
        return handResult;
    }

    private ArrayList<String> evaluateRoyal(int[] rankCounter, int[] suitCounter) {
        ArrayList<String> result = new ArrayList();
        if ((rankCounter[8] >= 1 && rankCounter[9] >= 1 && rankCounter[10] >= 1 && rankCounter[11] >= 1 && rankCounter[12] >= 1)
                && (suitCounter[0] > 4 || suitCounter[1] > 4 || suitCounter[2] > 4 || suitCounter[3] > 4)) {
            royalSearch:
            for (int i = 0; i < 3; i++) {
                if (allCards.get(i).getRank() == 8) {
                    for (int j = 1; j < 4 - i; j++) {
                        if ((allCards.get(i + j).getRank() == 9
                                && allCards.get(i + j + 1).getRank() == 10
                                && allCards.get(i + j + 2).getRank() == 11
                                && allCards.get(i + j + 3).getRank() == 12)
                                && (allCards.get(i).getSuit() == allCards.get(i + j).getSuit()
                                && allCards.get(i).getSuit() == allCards.get(i + j + 1).getSuit()
                                && allCards.get(i).getSuit() == allCards.get(i + j + 2).getSuit()
                                && allCards.get(i).getSuit() == allCards.get(i + j + 3).getSuit())) {
                            result.add("Royal Flush! " + Card.suitAsString(allCards.get(i).getSuit()) + ".");
                            result.add("1000");
                            break royalSearch;
                        }
                    }
                }
            }
        }
        return result;
    }

    private ArrayList<String> evaluateStraightFlush(int[] rankCounter, int[] suitCounter) {
        ArrayList<String> result = new ArrayList();
        if (suitCounter[0] > 4 || suitCounter[1] > 4 || suitCounter[2] > 4 || suitCounter[3] > 4) {
            for (int i = allCards.size() - 1; i > 3; i--) {
                if ((allCards.get(i).getRank() - ONE == allCards.get(i - ONE).getRank()
                        && allCards.get(i).getRank() - TWO == allCards.get(i - TWO).getRank()
                        && allCards.get(i).getRank() - THREE == allCards.get(i - THREE).getRank()
                        && allCards.get(i).getRank() - FOUR == allCards.get(i - FOUR).getRank())
                        && (allCards.get(i).getSuit() == allCards.get(i - ONE).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - TWO).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - THREE).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - FOUR).getSuit())) {
                    result.add("Straight Flush: " + Card.rankAsString(allCards.get(i).getRank()) + " high of " + Card.suitAsString(allCards.get(i).getSuit()) + ".");
                    result.add("900");
                    result.add(Card.rankAsString(allCards.get(i).getRank()));
                    break;
                }
            }
        }
        return result;
    }

    private ArrayList<String> evaluateFourOfAKind(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        for (int i = 0; i < rankCounter.length; i++) {
            if (rankCounter[i] == FOUR) {
                result.add("Four of a Kind: " + Card.rankAsString(i) + "'s.");
                result.add("800");
                result.add(Card.rankAsString(i));
                break;
            }
        }
        return result;
    }

    private ArrayList<String> evaluateFullHouse(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        short threeOfKindRank = -1;
        short twoOfKindRank = -1;
        for (int i = rankCounter.length; i > 0; i--) {
            if ((threeOfKindRank < (short) 0) || (twoOfKindRank < (short) 0)) {
                if ((rankCounter[i - ONE]) > 2 && threeOfKindRank < (short) 0) {
                    threeOfKindRank = (short) (i - ONE);
                } else if ((rankCounter[i - ONE]) > 1 && twoOfKindRank < (short) 0) {
                    twoOfKindRank = (short) (i - ONE);
                }
            } else {
                break;
            }
        }
        if ((threeOfKindRank >= (short) 0) && (twoOfKindRank >= (short) 0)) {
            result.add("Full House: " + Card.rankAsString(threeOfKindRank) + "'s full of " + Card.rankAsString(twoOfKindRank) + "'s.");
            result.add("700");
            result.add(Card.rankAsString(threeOfKindRank));
            result.add(Card.rankAsString(twoOfKindRank));
        }
        return result;
    }

    private ArrayList<String> evaluateFlush(int[] rankCounter, int[] suitCounter) {
        ArrayList<String> result = new ArrayList();
        if (suitCounter[0] > 4 || suitCounter[1] > 4 || suitCounter[2] > 4 || suitCounter[3] > 4) {
            for (int i = allCards.size() - 1; i > 3; i--) {
                if (allCards.get(i).getSuit() == allCards.get(i - ONE).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - TWO).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - THREE).getSuit()
                        && allCards.get(i).getSuit() == allCards.get(i - FOUR).getSuit()) {
                    result.add("Flush: " + Card.rankAsString(allCards.get(i).getRank()) + " high of " + Card.suitAsString(allCards.get(i).getSuit()) + ".");
                    result.add("600");
                    result.add(Card.rankAsString(allCards.get(i).getRank()));
                    break;
                }
            }
        }
        return result;
    }

    private ArrayList<String> evaluateStraight(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        for (int i = rankCounter.length; i > 4; i--) {
            if ((rankCounter[i - 1] > 0)
                    && (rankCounter[i - 2] > 0)
                    && (rankCounter[i - 3] > 0)
                    && (rankCounter[i - 4] > 0)
                    && (rankCounter[i - 5] > 0)) {
                result.add("Straight: " + Card.rankAsString(i - 1) + " high.");
                result.add("500");
                result.add(Card.rankAsString(i - 1));
                break;
            }
        }
        return result;
    }

    private ArrayList<String> evaluateThreeOfAKind(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        for (int i = rankCounter.length; i > 0; i--) {
            if (rankCounter[i - 1] > 2) {
                result.add("Three of a Kind: " + Card.rankAsString(i - 1) + "'s.");
                result.add("400");
                result.add(Card.rankAsString(i - 1));
                break;
            }
        }
        return result;
    }

    private ArrayList<String> evaluateTwoPair(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        short firstPairRank = -1;
        short secondPairRank = -1;
        for (int i = rankCounter.length; i > 0; i--) {
            if ((firstPairRank < (short) 0) || (secondPairRank < (short) 0)) {
                if (((rankCounter[i - ONE]) > 1) && (firstPairRank < (short) 0)) {
                    firstPairRank = (short) (i - ONE);
                } else if ((rankCounter[i - ONE]) > 1 && (secondPairRank < (short) 0)) {
                    secondPairRank = (short) (i - ONE);
                }
            } else {
                break;
            }
        }
        if ((firstPairRank >= (short) 0) && (secondPairRank >= (short) 0)) {
            result.add("Two Pair: " + Card.rankAsString(firstPairRank) + "'s and " + Card.rankAsString(secondPairRank) + "'s");
            result.add("300");
            result.add(Card.rankAsString(firstPairRank));
            result.add(Card.rankAsString(secondPairRank));
        }
        return result;
    }

    private ArrayList<String> evaluateOnePair(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        for (int i = rankCounter.length; i > 0; i--) {
            if ((rankCounter[i - ONE]) > 1) {
                result.add("One Pair: " + Card.rankAsString(i - ONE) + "'s");
                result.add("200");
                result.add(Card.rankAsString(i - ONE));
                break;
            }
        }
        return result;
    }

    private ArrayList<String> evaluateHighCard(int[] rankCounter) {
        ArrayList<String> result = new ArrayList();
        for (int i = rankCounter.length; i > 0; i--) {
            if ((rankCounter[i - ONE]) > 0) {
                result.add("High Card: " + Card.rankAsString(i - ONE));
                result.add("100");
                result.add(Card.rankAsString(i - ONE));
                break;
            }
        }
        return result;
    }
}
