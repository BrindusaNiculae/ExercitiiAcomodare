/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import exercitiiacomodare.twitter.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Brindu
 */
public class Exercitii {

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
         
         /*Problema2*/
        //System.out.println("\nBowling:");
        /*
         int[] rolls;
         int[] correctResult = new int[]{0, 20, 16, 24, 300, 78, 30, 75, 0, 120, 32};

         for (int i = 1; i <= 11; i++) {
         String filename = "Game" + (i) + ".in";
         Bowling ex2 = new Bowling();
         rolls = ex2.readFile(filename);
         ex2.setGameNr(i);
         int rezult = ex2.computeScoreFor(rolls);
         //            if( rezult == correctResult[i-1] ){
         //                System.out.println("CORECT");
         //            } else{
         //                System.out.println("INCORECT");
         //            }
         //            System.out.println("-Scorul final pt fisierul " + i
         //                    + " :" + rezult);
         //        }
         System.out.println(rezult);
         }
         */
      
    }
}
