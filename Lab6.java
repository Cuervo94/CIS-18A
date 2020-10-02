/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Pedro Longo
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int year = 1916;
        double tempYear[] = {-0.32, -0.40, -0.31, -0.25, -0.23, -0.16, -0.25, -0.25, -0.25, -0.18,-0.08, -0.18,
        -0.18, -0.33, -0.12, -0.06, -0.13, -0.26, -0.11, -0.16, -0.12, -0.01, -0.02, 0.01, 0.15, 0.27, 0.10, 0.10,
        0.28, 0.17, -0.01, -0.04, -0.05, -0.07, -0.15, 0.00, 0.05, 0.13, -0.10, -0.13, -0.18, 0.07, 0.13,
        0.08, 0.05, 0.10, 0.11, 0.12, -0.14, -0.07, -0.01, 0.00, -0.02, 0.01, 0.06, -0.06, 0.04, 0.20,
        -0.06, 0.02, -0.06, 0.22, 0.12, 0.23, 0.28, 0.33, 0.20, 0.36, 0.17, 0.16, 0.24, 0.39, 0.40, 0.30,
        0.45, 0.39, 0.24, 0.29, 0.35, 0.47, 0.33, 0.52, 0.66, 0.45, 0.43, 0.58, 0.63, 0.64, 0.59, 0.67, 
        0.64, 0.62, 0.55, 0.65, 0.73, 0.58, 0.64, 0.68, 0.74, 0.94, 1.00};
        
        for(int i = 0; i < 101; i++){
            System.out.println("Average global temperature in " + year + " was " + tempYear[i]);
            year += 1;
        }
        
        double sum = 0.00;
        for(double i : tempYear){
            sum += i;
        }
        System.out.println(sum/101);
        
        
        double maxValue = tempYear[0];
        
        for(int i = 1; i < tempYear.length; i++){
            if(tempYear[i] > maxValue){
                maxValue = tempYear[i];
            }
        }
        System.out.println("Maximum value in 100 years was: " + maxValue);
        
        double minValue = tempYear[0];
        
        for(int i = 1; i < tempYear.length; i++){
            if(tempYear[i] < minValue){
                minValue = tempYear[i];
            }
        }
        System.out.println("Minimum value in 100 years was: " + minValue);
    }
}