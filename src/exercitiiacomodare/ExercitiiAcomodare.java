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
        /*
        System.out.println("RomanToDecimal:");
        RomanNumber ex1 = new RomanNumber();
        System.out.println("Citeste nr roman: ");
        String nr = buff.readLine();
        System.out.println("Citeste o comanda: ");
        while (true) {
            s = buff.readLine();
            if (s.contains("c")) {
                ex1.doGeneralCheck(nr);
            } else if (s.contains("t")) {
                boolean b = ex1.getSyntaxCheckToggle();
                ex1.setSyntaxCheckToggle(!b);
            } else {
                ex1.transform(nr);
            }
        }

        //System.out.println("-Rezultatul decimal = " + ex1.transform(s));
        */
        
         /*Problema2*/
         System.out.println("\nBowling:");
         int [] rolls;
         for (int i = 1; i <= 8; i++) {
         String filename = "Game" + i + ".in";
         Bowling ex2 = new Bowling();
         rolls = ex2.readFile(filename);
         
         System.out.println("-Scorul final pt fisierul " + i
         + " :" + ex2.computeScoreFor(rolls));
         }
         

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
