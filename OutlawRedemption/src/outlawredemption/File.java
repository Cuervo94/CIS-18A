/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlawredemption;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cbran
 */
public class File {

    private static String fileName = "";

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        File.fileName = fileName;
    }

    public static void saveGame(Player player) throws IOException {
        PrintWriter pw = null;
        boolean done = false;
        while (!done) {
            setFileName(getUserInput("Enter a name for the file to save the game.") + ".txt");
            java.io.File file = new java.io.File(getFileName());
            if (file.createNewFile()) {
                pw = new PrintWriter(getFileName());
                displayMenu("File created.");
                done = true;
            } else {
                boolean quit = false;
                while (!quit) {
                    String choice = getUserInput("Would you like to overwrite the save file that already exists? (Y or N)");
                    if (choice.equalsIgnoreCase("y")) {
                        pw = new PrintWriter(new FileOutputStream(getFileName(), false));
                        displayMenu("File overwritten.");
                        done = true;
                        quit = true;
                    } else if (choice.equalsIgnoreCase("n")) {
                        quit = true;
                    } else {
                        displayOptionError();
                    }
                }
            }
        }
        pw.println(player.getCharacterName());
        pw.println(player.getGangName());
        pw.println(player.getMoney());
        pw.println(player.getChapter());
        pw.println(player.getDynamite());
        pw.println(player.getHonorPoints());
        pw.println(player.getTotalDeaths());
        pw.println(player.getTotalBJ());
        pw.println(player.getTotalBJWon());
        pw.println(player.getTotalBJLost());
        pw.println(player.getMoneyFromBJ());
        pw.println(player.getTotalPoker());
        pw.println(player.getTotalPokerWon());
        pw.println(player.getTotalPokerLost());
        pw.println(player.getTotalPokerTie());
        pw.println(player.getMoneyFromPoker());
        pw.println(player.getTotalDG());
        pw.println(player.getTotalDGWon());
        pw.println(player.getTotalDGLost());
        pw.println(player.getTotalDGTie());
        pw.println(player.getMoneyFromDG());
        pw.println(player.getTotalRPS());
        pw.println(player.getTotalRPSWon());
        pw.println(player.getTotalRPSLost());
        pw.println(player.getTotalRPSTie());
        pw.println(player.getTotalDrinks());
        pw.flush();
    }

    public static Player loadGame() throws FileNotFoundException, IOException {
        String name = getUserInput("Enter the name of the game you want to resume.") + ".txt";
        setFileName(name);
        BufferedReader br = new BufferedReader(new FileReader(getFileName()));
        ArrayList<String> gameFile = new ArrayList();
        String line;
        while ((line = br.readLine()) != null) {
            gameFile.add(line);
        }
        return new Player(gameFile.get(0), gameFile.get(1), Double.parseDouble(gameFile.get(2)), Integer.parseInt(gameFile.get(3)),
                Integer.parseInt(gameFile.get(4)), Integer.parseInt(gameFile.get(5)), Integer.parseInt(gameFile.get(6)),
                Integer.parseInt(gameFile.get(7)), Integer.parseInt(gameFile.get(8)), Integer.parseInt(gameFile.get(9)), Double.parseDouble(gameFile.get(10)),
                Integer.parseInt(gameFile.get(11)), Integer.parseInt(gameFile.get(12)), Integer.parseInt(gameFile.get(13)), Integer.parseInt(gameFile.get(14)), Double.parseDouble(gameFile.get(15)),
                Integer.parseInt(gameFile.get(16)), Integer.parseInt(gameFile.get(17)), Integer.parseInt(gameFile.get(18)), Integer.parseInt(gameFile.get(19)), Double.parseDouble(gameFile.get(20)),
                Integer.parseInt(gameFile.get(21)), Integer.parseInt(gameFile.get(22)), Integer.parseInt(gameFile.get(23)), Integer.parseInt(gameFile.get(24)), Integer.parseInt(gameFile.get(25)));
    }

    private static void displayMenu(String menu) {
        JOptionPane.showMessageDialog(null, menu);
    }

    public static void displayOptionError() {
        displayMenu("Please select an option listed.");
    }

    private static String getUserInput(String menu) {
        return JOptionPane.showInputDialog(menu);
    }
}
