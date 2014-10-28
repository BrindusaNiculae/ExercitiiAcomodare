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
public class Ex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Twitter ex3 = new Twitter();

        String s;
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));        
//        while (true) {
//            s = buff.readLine();
//            if (s.contains("EXIT")) {
//                break;
//            } else {
//                try {
//                    ex3.tweet(s);
//                } catch (InvalidUserException | ProfileNotSetException |
//                        InvalidEditProfileInputException |
//                        InvalidPhoneNrFormatException |
//                        InvalidMailFormatException ex) {
//                    System.exit(1);
//                   }
//            }
//
//        }
        String filename;

        for (int i = 1; i <= 5; i++) {
            ex3 = new Twitter();
            filename = "Scenario" + i + ".in";
            try {
                ex3.readFile(filename);
                String compareFile = "Scenario" + i + ".ok";
                System.out.println("Pentru testul " + i + ", rezultatul este: ");
                System.out.println(ex3.compareFiles(compareFile, "Scenario.out"));

            } catch (FileNotFoundException | InvalidUserException ex) {
                System.exit(1);
            } 
        }
    }
}
