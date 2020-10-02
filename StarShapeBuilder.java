/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;



/**
 *
 * @author Pedro Longo
 */
public class StarShapeBuilder {
    public static String getStarTriangle(int numberRows){
        String spacer = "";
        while (numberRows < 10){
            spacer += "*";
            numberRows++;        
        } return spacer;
    }
}
