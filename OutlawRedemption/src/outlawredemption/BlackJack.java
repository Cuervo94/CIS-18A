/*
 * Blackjack game
 */
package outlawredemption;

import java.util.*;
import javax.swing.JOptionPane;

public class BlackJack {
    
    private static final int[] deck = new int[52]; // 52 cards
    private static int currentPosition;
    
    public static void run(Player player) {
        double totalWon = 0;
        double bet = 0; // Amount user bets on a game.
        boolean userWins;
        boolean done = false;
        
        displayMenu("Welcome to the game of Blackjack.");
        
        while (!done) {
            displayMenu("You have $" + String.format("%.2f", player.getMoney()) + ".");
            boolean quit = false;
            while (!quit) {
                try {
                    bet = Double.parseDouble(getUserInput("How much do you want to bet? 0 to go back."));
                } catch (NumberFormatException ex) {
                    bet = -1;
                }
                if (bet < 0 || bet > player.getMoney()) {
                    displayMenu("Your bet must be between $0.01 and $" + String.format("%.2f", player.getMoney()) + ".");
                } else {
                    quit = true;
                }
            }
            if (bet == 0) {
                done = true;
            } else {
                userWins = playBlackjack();
                if (userWins) {
                    totalWon += bet;
                    player.addMoney(bet);
                    player.addBJW();
                    player.addBJMoney(bet);
                } else {
                    totalWon -= bet;
                    player.subtractMoney(bet);
                    player.addBJL();
                    player.addBJMoney(-bet);
                }
                if (player.getMoney() == 0) {
                    displayMenu("Looks like you're all out of money! Sorry!");
                    done = true;
                }
                player.addBJ();
            }
        }
        if (totalWon > 0) {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", winning a total of $" + String.format("%.2f", totalWon) + ".");
        } else if (totalWon < 0) {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", losing a total of $" + String.format("%.2f", Math.abs(totalWon)) + ".");
        } else {
            displayMenu("You leave with $" + String.format("%.2f", player.getMoney()) + ", exactly where you started.");
        }
    }
    
    private static boolean playBlackjack() {
        ArrayList<Integer> dealerHand = new ArrayList();
        ArrayList<Integer> userHand = new ArrayList();
        int cardCt = 0; // card count
        for (int suit = 0; suit < 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCt] = value;
                cardCt++;
            }
        }
        currentPosition = 0;
        shuffle();
        userHand.add(dealCard());
        dealerHand.add(dealCard());
        userHand.add(dealCard());
        dealerHand.add(dealCard());
        // Check if one of the players has two cards totaling to 21.
        // The player with Blackjack wins the game. Dealer wins ties.
        if (value(dealerHand) == 21) {
            displayMenu("Dealer has the " + showCard(getCard(dealerHand, 0)) + " and the " + showCard(getCard(dealerHand, 1)) + ".\n"
                    + "User has the " + showCard(getCard(userHand, 0)) + " and the " + showCard(getCard(userHand, 1)) + ".\n\n"
                    + "Dealer has Blackjack. Dealer wins.");
            return false;
        }
        if (value(userHand) == 21) {
            displayMenu("Dealer has the " + showCard(getCard(dealerHand, 0)) + " and the " + showCard(getCard(dealerHand, 1)) + ".\n"
                    + "User has the " + showCard(getCard(userHand, 0)) + " and the " + showCard(getCard(userHand, 1)) + ".\n\n"
                    + "You have Blackjack. You win.");
            return true;
        }
        boolean done = false;
        while (!done) {
            // Display user's cards, and let user decide to Hit or Stand.
            String cardsInHand = "Your cards are:\n";
            for (int i = 0; i < userHand.size(); i++) {
                cardsInHand += (showCard(getCard(userHand, i)) + "\n");
            }
            cardsInHand += ("\nYour total is " + value(userHand) + ".\n\n"
                    + "Dealer is showing the " + showCard(getCard(dealerHand, 0)) + ".\n\n"
                    + "Hit (H) or Stand (S)? ");
            String userAction = "";
            boolean quit = false;
            while (!quit) {
                userAction = getUserInput(cardsInHand); // 'H' or 'S'
                if (userAction.equalsIgnoreCase("H") || userAction.equalsIgnoreCase("S")) {
                    quit = true;
                } else {
                    displayMenu("Please respond H or S: ");
                }
            }
            if (userAction.equalsIgnoreCase("S")) {
                done = true;
            } else {
                // Give the user a card. If the user goes over 21, the user loses.
                String menu = "You decided to hit.\n\n";
                int newCard = dealCard();
                userHand.add(newCard);
                menu += ("Your card is the " + showCard(newCard) + ".\n\n");
                menu += ("Your total is now " + value(userHand) + ".");
                displayMenu(menu);
                if (value(userHand) > 21) {
                    menu = "You busted by going over 21. You lose.\n\n"
                            + "Dealer's other card was the " + showCard(getCard(dealerHand, 1)) + ".\n\n"
                            + "Dealer's total is " + value(dealerHand) + ".";
                    displayMenu(menu);
                    return false;
                }
            }
        }
        // User has Stood with 21 or less. Now, it's
        // the dealer's chance to draw. Dealer draws cards until the dealer's total is > 16.
        String menu = "User stands.\n\n"
                + "Dealer's cards are:\n"
                + showCard(getCard(dealerHand, 0)) + "\n"
                + showCard(getCard(dealerHand, 1)) + "\n\n"
                + "Dealer's total is " + value(dealerHand) + ".";
        displayMenu(menu);
        checkSoft17(dealerHand);
        while (value(dealerHand) < 17) {
            int newCard = dealCard();
            dealerHand.add(newCard);
            displayMenu("Dealer hits and gets the " + showCard(newCard) + ".\n\n"
                    + "Dealer's total is now " + value(dealerHand) + ".");
        }
        checkSoft17(dealerHand);
        // Now, winner can be declared. 
        if (value(dealerHand) > 21) {
            displayMenu("Dealer busted by going over 21. You win.");
            return true;
        } else {
            if (value(dealerHand) == value(userHand)) {
                displayMenu("Dealer wins on a tie. You lose.");
                return false;
            } else {
                if (value(dealerHand) > value(userHand)) {
                    displayMenu("Dealer wins, " + value(dealerHand) + " points to " + value(userHand) + ".");
                    return false;
                } else {
                    displayMenu("You win, " + value(userHand) + " points to " + value(dealerHand) + ".");
                    return true;
                }
            }
        }
    }
    
    public static void shuffle() {
        for (int i = 51; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            int temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        currentPosition = 0;
    }
    
    public static int dealCard() {
        // Deals one card from the deck and returns it.
        if (currentPosition == 52) {
            shuffle();
        }
        currentPosition++;
        return deck[currentPosition - 1];
    }
    
    public static int getCard(ArrayList<Integer> hand, int position) {
        // Get the card from the hand in given position, where positions
        // are numbered starting from 0. 
        if (position >= 0 && position < hand.size()) {
            return hand.get(position);
        } else {
            return 0;
        }
    }
    
    public static String showCard(int card) {
        if (card == 1) {
            return "Ace";
        } else if (card == 2) {
            return "2";
        } else if (card == 3) {
            return "3";
        } else if (card == 4) {
            return "4";
        } else if (card == 5) {
            return "5";
        } else if (card == 6) {
            return "6";
        } else if (card == 7) {
            return "7";
        } else if (card == 8) {
            return "8";
        } else if (card == 9) {
            return "9";
        } else if (card == 10) {
            return "10";
        } else if (card == 11) {
            return "Jack";
        } else if (card == 12) {
            return "Queen";
        } else if (card == 13) {
            return "King";
        } else {
            return "??";
        }
    }
    
    public static int value(ArrayList<Integer> hand) {
        int val = 0;
        boolean ace = false;
        int cards = hand.size(); //cards in hand
        for (int i = 0; i < cards; i++) {
            // Add the value of the card in the hand.
            int card = getCard(hand, i);
            int cardVal = getCardValue(card); // The normal value from 1 to 13.
            if (cardVal > 10) {
                cardVal = 10; // for a Jack, Queen, or King.
            }
            if (cardVal == 1) {
                ace = true; // There is at least one ace.
            }
            val += cardVal;
        }
        // Now, val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to the value.
        if (ace == true && val + 10 <= 21) {
            val += 10;
        }
        return val;
    }
    
    public static int getCardValue(int card) {
        if (card == 11 || card == 12 || card == 13) {
            return 10;
        } else {
            return card;
        }
    }
    
    public static void checkSoft17(ArrayList<Integer> dealerHand) {
        boolean ace = false;
        for (int i = 0; i < dealerHand.size(); i++) {
            if (showCard(getCard(dealerHand, i)).equalsIgnoreCase("Ace")) {
                ace = true;
            }
        }
        if (ace && value(dealerHand) == 17) {
            int newCard = dealCard();
            dealerHand.add(newCard);
            displayMenu("Dealer hits and gets the " + showCard(newCard) + ".\n"
                    + "Dealer's total is now " + value(dealerHand) + ".");
        }
    }
    
    private static void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }
    
    private static String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }
}
