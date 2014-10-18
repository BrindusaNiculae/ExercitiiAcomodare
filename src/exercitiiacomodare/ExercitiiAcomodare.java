/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        /*Problema 1*/
        System.out.println("RomanToDecimal:");
        RomanNumber ex1 = new RomanNumber();

        while (true) {
            s = buff.readLine();
            
            if (s.contains("t")) {
                boolean b = ex1.getSyntaxCheckToggle();
                ex1.setSyntaxCheckToggle(!b);
            } else {
                ex1.transform(s);
            }
        }

        //System.out.println("-Rezultatul decimal = " + ex1.transform(s));
        /*
         /*Problema2
         System.out.println("\nBowling:");
         Bowling ex2 = new Bowling();
         for (int i = 1; i <= 8; i++) {
         String filename = "Game" + i + ".in";

         System.out.println("-Scorul final pt fisierul " + i
         + " :" + ex2.processGame(filename));
         }
         */

        /*Problema3*/
        /*
         System.out.println("\nTwitter");
         Twitter ex3 = new Twitter();
         while (true) {
         s = buff.readLine();
            
         if (s.contains("EXIT")) {
         break;
         } else {
         ex3.tweet(s);
         }

         }
         */
    }
}
