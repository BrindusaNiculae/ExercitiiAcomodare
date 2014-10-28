/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare.twitter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class ExercitiiAcomodare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String s;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Twitter ex3 = new Twitter();
//        while (true) {
//            s = buff.readLine();
//            if (s.contains("EXIT")) {
//                break;
//            } else {
//                ex3.tweet(s);
//            }
//
//        }
        String filename;
        filename = "Scenario5.in";
        try {
            ex3.readFile(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercitiiAcomodare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidUserException ex) {
            Logger.getLogger(ExercitiiAcomodare.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(ex3.compareFiles("Scenario1.ok", "Scenario.out"));
//        filename = "Scenario2.in";
//       ex3 = new Twitter();
//        ex3.readFile(filename);
//        System.out.println(ex3.compareFiles("Scenario2.ok", "Scenario.out"));
//        filename = "Scenario3.in";
//        ex3 = new Twitter();
//        ex3.readFile(filename);
//  
    }
}
