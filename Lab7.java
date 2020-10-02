/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pedro Longo
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Create a program that does the following:
        boolean done = false;
//
//Create a menu with the following options:

        while (!done) {
            Game game = new Game();

            Integer choice = game.StartMenu();

            if (choice == 1) {
                game.Play();

            } else if (choice == 2) {
                System.out.println("Please enter a name for file");
                Scanner input = new Scanner(System.in);

                String fileName = input.nextLine();

                BufferedReader in;
                try {
                    in = new BufferedReader(new FileReader(fileName));
                    while (true) {
                        String line = in.readLine();
                        if (line == null){
                            break;
                        } else {
                            System.out.println(line);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                } catch (IOException ex) {
                    System.out.println("Unable to read the file");
                }

            } else if (choice == 3) {
                done = true;
            } else {
                System.out.println("Please make a valid selection");
            }
        }

//Start a game
//Display Game (by filename)
//End Game
//Roll the dice and store the dice rolls in memory
    }
//Continue to roll the dice and store the results in memory until either the winning number is rolled, or a 7 or 11 is rolled.
//If 7 or 11 is rolled, let the user know they've lost, prompt the user for a filename to save the dice rolls in that file and go back to the menu.
//If the winning number is rolled, let the user know they've won, prompt the user for a filename to save the dice rolls in that file and go back to the menu.
//NOTE: If the user enters a file name that doesn't exist, tell them it doesn't exist (handle the exception).
//
}
