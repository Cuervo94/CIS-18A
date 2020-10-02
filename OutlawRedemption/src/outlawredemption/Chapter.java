/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Norco College
 */
public abstract class Chapter {

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public abstract void startChapter(Player player);

    public abstract void part1(Player player);

    public abstract void part2(Player player);

    public void saveGame(Player player, Chapter chapter, Integer ch) {
        boolean quit = false;
        while (!quit) {
            String selection = getUserInput("Would you like to save your game? (Y or N)");
            if (selection.equalsIgnoreCase("y")) {
                player.setChapter(ch);
                try {
                    File.saveGame(player);
                } catch (IOException ex) {
                    displayMenu("IOException thrown.");
                }
                boolean quit2 = false;
                while (!quit2) {
                    selection = getUserInput("Would you like to continue your game? (Y or N)");
                    if (selection.equalsIgnoreCase("y")) {
                        quit2 = true;
                        chapter.startChapter(player);
                    } else if (selection.equalsIgnoreCase("n")) {
                        displayMenu("Returning to main menu.");
                        quit2 = true;
                    }
                }
                quit = true;
            } else if (selection.equalsIgnoreCase("n")) {
                quit = true;
                chapter.startChapter(player);
            } else {
                displayOptionError();
            }
        }
    }

    public void ending(Player player) {
        ImageIcon icon;
        String menu = "";
        if (player.getHonorPoints() > -15 && player.getHonorPoints() < 15) {
            menu += ("You got the Neutral ending. [DEAD]\n\n");
            icon = new ImageIcon("dead.png");
        } else if (player.getHonorPoints() >= 15) {
            menu += ("You got the Honorable ending. [GUNSLINGER]\n\n");
            icon = new ImageIcon("gunslinger.png");
        } else if (player.getHonorPoints() <= -15) {
            menu += ("You got the Dishonorable ending. [OUTLAW]\n\n");
            icon = new ImageIcon("outlaw.png");
        } else {
            displayMenu("I don't know how you are seeing this.");
            icon = null;
        }
        menu += "Name: " + player.getCharacterName() + "\n"
                + "Gang: " + player.getGangName() + "\n"
                + "Total Money: $" + String.format("%.2f", player.getMoney()) + "\n"
                + "Honor Points: " + player.getHonorPoints() + "\n"
                + "Total Deaths: " + player.getTotalDeaths() + "\n"
                + "Total Drinks Bought: " + player.getTotalDrinks() + "\n"
                + "Total Blackjack Games Played: " + player.getTotalBJ() + "\n"
                + "Total Blackjack Games Won: " + player.getTotalBJWon() + "\n"
                + "Total Blackjack Games Lost: " + player.getTotalBJLost() + "\n"
                + player.getBJMoney()
                + "Total Poker Hands Played: " + player.getTotalPoker() + "\n"
                + "Total Poker Hands Won: " + player.getTotalPokerWon() + "\n"
                + "Total Poker Hands Lost: " + player.getTotalPokerLost() + "\n"
                + "Total Poker Hands Tied: " + player.getTotalPokerTie() + "\n"
                + player.getPokerMoney()
                + "Total Dice Games Played: " + player.getTotalDG() + "\n"
                + "Total Dice Games Won: " + player.getTotalDGWon() + "\n"
                + "Total Dice Games Lost: " + player.getTotalDGLost() + "\n"
                + "Total Dice Games Tied: " + player.getTotalDGTie() + "\n"
                + player.getDGMoney()
                + "Total Rock, Paper, Scissors Games Played: " + player.getTotalRPS() + "\n"
                + "Total Rock, Paper, Scissors Games Won: " + player.getTotalRPSWon() + "\n"
                + "Total Rock, Paper, Scissors Games Lost: " + player.getTotalRPSLost() + "\n"
                + "Total Rock, Paper, Scissors Games Tied: " + player.getTotalRPSTie() + "\n";
        displayMenuIcon(menu, icon);
    }

    public void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    public void displayOptionError() {
        displayMenu("Please select an option listed.");
    }

    public String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }

    public void displayDead(Player player) {
        player.addDeath();
        displayMenu("DEAD");
    }

    private void displayMenuIcon(String menu, ImageIcon icon) {
        JOptionPane.showMessageDialog(null, menu, "Wanted Poster", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
