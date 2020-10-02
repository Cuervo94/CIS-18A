/* Each player starts with 100 points.
 * During one round, each player rolls one die.
 * The player with the lower roll loses the number of points shown on the higher die.
 */
package outlawredemption;

import javax.swing.JOptionPane;

public class DiceGame {

    public static void run(Player player) {
        long roll1, roll2;
        double totalWon = 0;
        int intBet = 0;
        int rounds = 0;

        boolean done = false;
        while (!done) {
            displayMenu("You have $" + String.format("%.2f", player.getMoney()) + ".");
            int player1 = 100;
            int stranger = 100;
            boolean quit = false;
            while (!quit) {
                String bet = getUserInput("Please enter the amount of money you want to bet. ($1.00 for 5 rounds) 0 to go back");
                try {
                    intBet = Integer.parseInt(bet);
                } catch (NumberFormatException ex) {
                    intBet = -1;
                }
                if (intBet == 0) {
                    quit = true;
                } else if (intBet > player.getMoney() || intBet < 1) {
                    displayMenu("Your bet must be between $1.00 and $" + String.format("%.2f", Math.floor(player.getMoney())) + ".");
                } else {
                    quit = true;
                }
            }
            rounds = 5 * intBet;
            if (intBet == 0) {
                done = true;
            } else {
                for (int i = 1; i <= rounds; i++) {
                    roll1 = Math.round(Math.random() * 100) % 6 + 1;
                    roll2 = Math.round(Math.random() * 100) % 6 + 1;
                    displayMenu("Round " + i + ": Player: " + roll1 + " Stranger: " + roll2);
                    if (roll1 < roll2) {
                        player1 -= roll2;
                    } else if (roll1 > roll2) {
                        stranger -= roll1;
                    } else {
                        player1 -= roll1;
                        stranger -= roll1;
                    }
                    displayMenu("Player points: " + player1 + "\n"
                            + "Stranger points: " + stranger);
                }
                if (player1 > stranger) {
                    player.addMoney((double) intBet);
                    player.addDGW();
                    player.addDGMoney((double) intBet);
                    totalWon += (double) intBet;
                    displayMenu("You win!");
                } else if (player1 < stranger) {
                    player.subtractMoney((double) intBet);
                    player.addDGL();
                    player.addDGMoney((double) -intBet);
                    totalWon -= (double) intBet;
                    displayMenu("You lose.");
                } else {
                    player.addDGT();
                    displayMenu("Draw. Nobody wins.");
                }
                if (player.getMoney() < 1.00) {
                    displayMenu("Looks like you don't have enough to play! Sorry!");
                    done = true;
                }
                player.addDG();
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

    private static void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    private static String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }
}
