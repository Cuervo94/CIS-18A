/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Norco College
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean done = false;
        
        while (!done){
            JOptionPane.showMessageDialog(null, "Lab Activity 3");
            
            String mainMenu = "       Main Menu\n";
            mainMenu += "1. 10 line tree\n";
            mainMenu += "2. Build star tree\n";
            mainMenu += "3. 10 line Christmas tree\n";
            mainMenu += "4. Build Christms tree\n";
            
            String stringChoice = JOptionPane.showInputDialog(mainMenu);
            int choice = Integer.parseInt(stringChoice);
            
            if (choice == 1){
                String stars = ""; 
                int i = 0;
 
                while (i < 10){
                    System.out.println(stars);
                    stars += "*";
                    i++;
                }  
            } else if (choice == 2){
                String stars = "";
                int i = 0;
                int numberStars = 0;
                
                System.out.println("How many rows do you want on the tree?");
                Scanner input = new Scanner(System.in);
                numberStars = input.nextInt();
                
                while (i < numberStars){
                    System.out.println(stars);
                    stars += "*";
                    i++;
                }
            } else if (choice == 3){
                String spacer = "";
                  for(int i = 0; i < 10; i++){
                      spacer = "";
                      for(int j = 0; j < 21; j++){
                        if(i >= 0){
                            if(j == 10-i || j == 10 + i){
                                spacer += "*";
                            } else{
                                spacer += "_";
                            }
                        }
                      }
                      System.out.println(spacer);
                  }         
            } else if (choice == 4) {
                String spacer = "";
                int numberRows = 0;
                
                System.out.println("How many rows do you want on the tree?");
                Scanner input = new Scanner(System.in);
                numberRows = input.nextInt();
                
                for(int i = 0; i < numberRows; i++){
                      spacer = "";
                      for(int j = 0; j < (numberRows * 2 + 1); j++){
                        if(numberRows >= 0){
                            if(j == numberRows -i || j == numberRows + i){
                                spacer += "*";
                            } else{
                                spacer += "_";
                            }
                        }
                      }
                      System.out.println(spacer);
                  } 
            }
            else {
                System.out.println("Please make a selection");
            }
        }
    }
}

