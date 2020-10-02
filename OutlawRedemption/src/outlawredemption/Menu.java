/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Norco College
 */
public class Menu {

    boolean done = false;
    Story story = new Story();
    Player player;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void start() throws IOException {
        setDone(false);
        displayMenu("Welcome to Outlaw Redemption!");
        while (!isDone()) {
            processUserInput(getUserInput("1. New Game\n2. Continue Game\n3. Exit"));
        }
    }

    public void processUserInput(String choice) throws IOException {
        if (choice.equals("1")) {
            player = new Player(CharacterName(), GangName(), 50.00);
            story.mainStory(player);
        } else if (choice.equals("2")) {
            try {
                story.resume(File.loadGame());
            } catch (FileNotFoundException ex) {
                displayMenu("No game file found yet.\nCreate one by starting a game.");
            } catch (IOException ex) {
                displayMenu("Unable to read game file.\nCreate one by starting a game.");
            }
        } else if (choice.equals("3")) {
            setDone(true);
        } else {
            displayOptionError();
        }
    }

    private void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    private void displayOptionError() {
        displayMenu("Please select an option listed.");
    }

    private String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }

    public String CharacterName() {
        return getUserInput("Enter your character's name.");
    }

    public String GangName() {
        return getUserInput("Enter your gang's name.");
    }
}
