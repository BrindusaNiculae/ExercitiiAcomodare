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
        /*Problema 1*/
         System.out.println("RomanToDecimal:");
         System.out.println("-Scrie un nr roman valid la tastatura:");

         String s;
         BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
         s = buff.readLine();

         RomanToDecimal ex1 = new RomanToDecimal();
         System.out.println("-Rezultatul decimal = " + ex1.transform(s));                 

         /*Problema2*/
        System.out.println("\nBowling:");
        Bowling ex2 = new Bowling();
        for (int i = 1; i <= 8; i++) {
            String filename = "Game" + i + ".in";

            System.out.println("-Scorul final pt fisierul " + i
                    + " :" + ex2.processGame(filename));
        }
    }
}