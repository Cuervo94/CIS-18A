package outlawredemption;

import java.util.Random;
import javax.swing.JOptionPane;

public class RockPaper {

    public static void run(Player player) {
        displayMenu("Welcome to rock, paper, scissors!");
        boolean done = false;
        while (!done) {
            int p = readInput();
            int c = randomInput();
            if (p == c) {
                displayMenu("It's a tie");
                player.addRPST();
            } else if (p == 1 && c == 2) { //player: rock  cpu: paper
                displayMenu("Paper covers rock. You lose!!");
                player.addRPSL();
            } else if (p == 1 && c == 3) { //player: rock  cpu: scissors
                displayMenu("Rock crushes scissors. You win!!");
                player.addRPSW();
            } else if (p == 2 && c == 1) {//player: paper  cpu: rock
                displayMenu("Paper covers rock. You win!!");
                player.addRPSW();
            } else if (p == 2 && c == 3) {//player: paper  cpu: scissors
                displayMenu("Scissor cuts paper. You lose!!");
                player.addRPSL();
            } else if (p == 3 && c == 1) {//player: scissors  cpu: rock
                displayMenu("Rock breaks scissors. You lose!!");
                player.addRPSL();
            } else if (p == 3 && c == 2) { //player: scissors  cpu: paper
                displayMenu("Scissor cuts paper. You win!!");
                player.addRPSW();
            }
            player.addRPS();
            boolean quit = false;
            while (!quit) {
                String choice = getUserInput("Play again? (Y or N)");
                if (choice.equalsIgnoreCase("y")) {
                    done = false;
                    quit = true;
                } else if (choice.equalsIgnoreCase("n")) {
                    done = true;
                    quit = true;
                } else {
                    displayMenu("Please select a valid option.");
                }
            }
        }
        displayMenu("Thanks for playing! Come back soon!");
    }

    public static int readInput() {
        String menu = ("To play a game of rock, paper, scissors, please enter a move.\n"
                + "1: Rock\n"
                + "2: Paper\n"
                + "3: Scissors\n");
        String choice = "0";
        boolean done = false;
        while (!done) {
            choice = getUserInput(menu);
            if (choice.equals("1")) {
                displayMenu("Your move is rock.");
                done = true;
            } else if (choice.equals("2")) {
                displayMenu("Your move is paper.");
                done = true;
            } else if (choice.equals("3")) {
                displayMenu("Your move is scissors.");
                done = true;
            } else {
                displayMenu("Please select a valid option.");
            }
        }
        return Integer.parseInt(choice);
    }

    public static int randomInput() {
        Random number = new Random();
        int cpu = number.nextInt(3) + 1;
        if (cpu == 1) {
            displayMenu("Cpu's move is rock.");
        } else if (cpu == 2) {
            displayMenu("Cpu's move is paper.");
        } else if (cpu == 3) {
            displayMenu("Cpu's move is scissors.");
        }
        return cpu;
    }

    public static void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    public static String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }
}
