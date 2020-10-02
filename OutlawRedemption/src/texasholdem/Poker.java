/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import outlawredemption.Player;

/**
 *
 * @author cbran
 */
public class Poker {

    private static double bet = 0.00;
    private static double totalWon = 0.00;

    public static void start(Player player) {
        setTotalWon(0.00);
        displayMenu("Welcome to Texas Hold'em!");
        boolean done = false;
        while (!done) {
            String choice = getUserInput("Would you like to play a hand? (Y or N)");
            if (choice.equalsIgnoreCase("n")) {
                done = true;
            } else if (choice.equalsIgnoreCase("y")) {
                setBet(0.00);
                playPoker(player);
                if (player.getMoney() == 0.00) {
                    displayMenu("Looks like you're all out of money! Sorry!");
                    done = true;
                }
            } else {
                displayMenu("Please enter Y or N.");
            }
        }
        if (getTotalWon() > 0.00) {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", winning a total of $" + String.format("%.2f", getTotalWon()) + ".");
        } else if (getTotalWon() < 0.00) {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", losing a total of $" + String.format("%.2f", Math.abs(getTotalWon())) + ".");
        } else {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", exactly where you started.");
        }
    }

    private static void playPoker(Player player) {
        Deck deck = new Deck();
        Table table = new Table();
        Hand playerHand = new Hand();
        Hand strangerHand = new Hand();
        int cardCounter = 0;
        for (int i = 0; i < 3; i++) {
            deck.shuffle();
        }
        deck.cut();
        playerHand.addCard(deck.drawCard(cardCounter++));
        strangerHand.addCard(deck.drawCard(cardCounter++));
        playerHand.addCard(deck.drawCard(cardCounter++));
        strangerHand.addCard(deck.drawCard(cardCounter++));
        addBet(getBetFromUser(player, "", playerHand));
        table.addBurnCard(deck.drawCard(cardCounter++));
        table.addCommunityCard(deck.drawCard(cardCounter++));
        table.addCommunityCard(deck.drawCard(cardCounter++));
        table.addCommunityCard(deck.drawCard(cardCounter++));
        addBet(getBetFromUser(player, "The flop is:\n" + table.communityToString() + "\n\n", playerHand));
        table.addBurnCard(deck.drawCard(cardCounter++));
        table.addCommunityCard(deck.drawCard(cardCounter++));
        addBet(getBetFromUser(player, "The turn is:\n" + table.communityToString() + "\n\n", playerHand));
        table.addBurnCard(deck.drawCard(cardCounter++));
        table.addCommunityCard(deck.drawCard(cardCounter++));
        addBet(getBetFromUser(player, "The river is:\n" + table.communityToString() + "\n\n", playerHand));
        ArrayList<String> pHandVal = evaluateHand(playerHand, table);
        ArrayList<String> sHandVal = evaluateHand(strangerHand, table);
        String showDown = "The table is:\n" + table.communityToString() + "\n\n"
                + "Your hand is:\n" + playerHand.handToString() + "\n" + pHandVal.get(0) + "\n\n"
                + "Stranger's hand is:\n" + strangerHand.handToString() + "\n" + sHandVal.get(0) + "\n\n";
        int pHandValue = Integer.parseInt(pHandVal.get(1));
        int sHandValue = Integer.parseInt(sHandVal.get(1));
        ArrayList<Integer> pHighCard = getHighCards(pHandVal, pHandValue);
        ArrayList<Integer> sHighCard = getHighCards(sHandVal, sHandValue);
        if (pHandValue > sHandValue) {
            showDown += win(player);
        } else if (pHandValue < sHandValue) {
            showDown += lose(player);
        } else if (pHandValue == sHandValue) {
            if (pHandValue == 1000) {
                showDown += tie(player);
            } else if (pHandValue == 900 || pHandValue == 800 || pHandValue == 600 || pHandValue == 500
                    || pHandValue == 400 || pHandValue == 200 || pHandValue == 100) {
                if (pHighCard.get(0) > sHighCard.get(0)) {
                    showDown += win(player);
                } else if (pHighCard.get(0) < sHighCard.get(0)) {
                    showDown += lose(player);
                } else if (pHighCard.get(0).equals(sHighCard.get(0))) {
                    showDown += tie(player);
                }
            } else if (pHandValue == 700 || pHandValue == 300) {
                if (pHighCard.get(0) > sHighCard.get(0)) {
                    showDown += win(player);
                } else if (pHighCard.get(0) < sHighCard.get(0)) {
                    showDown += lose(player);
                } else if (pHighCard.get(0).equals(sHighCard.get(0))) {
                    if (pHighCard.get(1) > sHighCard.get(1)) {
                        showDown += win(player);
                    } else if (pHighCard.get(1) < sHighCard.get(1)) {
                        showDown += lose(player);
                    } else if (pHighCard.get(1).equals(sHighCard.get(1))) {
                        showDown += tie(player);
                    }
                }
            }
        }
        displayMenu(showDown);
        player.addPoker();
//        deck.displayDeck();
//        System.out.println("\n");
//        table.displayCommunity();
//        System.out.println("\n");
//        playerHand.displayHand();
//        System.out.println("\n");
//        strangerHand.displayHand();
//        System.out.println("\n");
    }

    private static double getBetFromUser(Player player, String menu, Hand hand) {
        double b = 0;
        boolean quit = false;
        while (!quit) {
            try {
                b = Double.parseDouble(getUserInput(getStringMoney(player) + "\n\n" + menu + getUserHand(hand)));
            } catch (NumberFormatException ex) {
                b = -1;
            }
            if (b < 0 || b > player.getMoney()) {
                displayMenu("Your bet must be between $0.00 and $" + String.format("%.2f", player.getMoney()) + ".");
            } else {
                quit = true;
            }
            if (b == 0) {
                quit = true;
            }
        }
        player.subtractMoney(b);
        return b;
    }

    private static ArrayList<String> evaluateHand(Hand hand, Table table) {
        HandValue handValue = new HandValue();
        for (int i = 0; i < hand.size(); i++) {
            handValue.addCard(hand.getCard(i));
        }
        for (int i = hand.size(); i < (hand.size() + table.size()); i++) {
            handValue.addCard(table.getCommunityCard(i - hand.size()));
        }
        return handValue.evaluateHand();
    }

    private static ArrayList<Integer> getHighCards(ArrayList<String> handVal, int value) {
        ArrayList<Integer> highCardValues = new ArrayList();
        if (value == 900 || value == 800 || value == 600 || value == 500
                || value == 400 || value == 200 || value == 100) {
            highCardValues.add(getRank(handVal, 2));
        } else if (value == 700 || value == 300) {
            highCardValues.add(getRank(handVal, 2));
            highCardValues.add(getRank(handVal, 3));
        }
        return highCardValues;
    }

    private static int getRank(ArrayList<String> handVal, int position) {
        if (handVal.get(position).equalsIgnoreCase("Ace")) {
            return 14;
        } else if (handVal.get(position).equalsIgnoreCase("King")) {
            return 13;
        } else if (handVal.get(position).equalsIgnoreCase("Queen")) {
            return 12;
        } else if (handVal.get(position).equalsIgnoreCase("Jack")) {
            return 11;
        } else {
            return Integer.parseInt(handVal.get(position));
        }
    }

    private static String win(Player player) {
        player.addMoney(getBet() * 2);
        player.addPokerW();
        player.addPokerMoney(getBet());
        addTotalWon(getBet());
        return "You won the hand! You win $" + getMoneyFormat(getBet() * 2) + ".";
    }

    private static String lose(Player player) {
        player.addPokerL();
        player.addPokerMoney(-getBet());
        subTotalWon(getBet());
        return "You lost the hand! You lose $" + getMoneyFormat(getBet()) + ".";
    }

    private static String tie(Player player) {
        player.addMoney(getBet());
        player.addPokerT();
        return "You tied the hand! You get $" + getMoneyFormat(getBet()) + " back.";
    }

    private static double getBet() {
        return Poker.bet;
    }

    private static void setBet(double bet) {
        Poker.bet = bet;
    }

    private static void addBet(double amt) {
        Poker.bet += amt;
    }

    private static double getTotalWon() {
        return Poker.totalWon;
    }

    private static void setTotalWon(double totalWon) {
        Poker.totalWon = totalWon;
    }

    private static void addTotalWon(double amt) {
        Poker.totalWon += amt;
    }

    private static void subTotalWon(double amt) {
        Poker.totalWon -= amt;
    }

    private static String getUserHand(Hand hand) {
        return "Your hand is:\n" + hand.handToString() + "\n\nHow much do you want to bet? 0 to check.";
    }

    private static String getMoneyFormat(double amt) {
        return String.format("%.2f", amt);
    }

    private static String getStringMoney(Player player) {
        return "You have $" + getMoneyFormat(player.getMoney()) + ".";
    }

    private static void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    private static String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }
}
