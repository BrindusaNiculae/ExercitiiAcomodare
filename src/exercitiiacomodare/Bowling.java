/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Bowling {

    private int roll1, roll2 = -1, nextRoll1 = -1, nextRoll2 = -1;
    private int score;
    private int nrOfPerfectRolls = 0;

    public int processGame(String filename) throws FileNotFoundException {
        score = 0;
        roll2 = -1;
        nextRoll1 = -1;
        nextRoll2 = -1;

        Scanner scanner = new Scanner(new File(filename));
        roll1 = scanner.nextInt();

        while (true) {
            /*STRIKE*/
            if (roll1 == 10) {
                nrOfPerfectRolls++;

                if (nrOfPerfectRolls == 12) {
                    return 300;
                }
                if ((roll2 != -1) && (roll2 != 10)) {
                    nextRoll1 = roll2;
                } else if ((scanner.hasNextInt()) && (nextRoll1 == -1)) {
                    nextRoll1 = scanner.nextInt();
                }
                if (scanner.hasNextInt()) {
                    nextRoll2 = scanner.nextInt();
                    score += roll1 + nextRoll1 + nextRoll2;
                    roll1 = nextRoll1;
                    roll2 = nextRoll2;
                    nextRoll1 = -1;
                    nextRoll2 = -1;
                } /*Daca nu exista nextRoll2 => game over */ else {
                    score += 30;
                    return score;
                }
            }
            /*Daca am mai multe STRIKE la rand, roll2 va fi 10*/
            if (roll2 == 10) {
                nrOfPerfectRolls++;
                if (nrOfPerfectRolls == 12) {
                    return 300;
                }
                roll2 = -1;
                nextRoll1 = 10;
            }/*Daca este SPARE sau OPEN*/ else {
                if (roll2 == -1) {
                    roll2 = scanner.nextInt();
                }
                if (scanner.hasNextInt()) {
                    nextRoll1 = scanner.nextInt();

                    if (scanner.hasNextInt()) {
                        nextRoll2 = scanner.nextInt();

                        /*SPARE*/
                        if ((roll1 + roll2) == 10) {
                            score += (roll1 + roll2 + nextRoll1);
                            roll1 = nextRoll1;
                            roll2 = nextRoll2;
                            nextRoll1 = -1;
                            nextRoll2 = -1;
                        } /*OPEN*/ else if ((roll1 + roll2) < 10) {
                            score += (roll1 + roll2);
                            roll1 = nextRoll1;
                            roll2 = nextRoll2;
                            nextRoll1 = -1;
                            nextRoll2 = -1;
                        }
                    } /*Daca nu exista nextRoll2 => game over*/ else {
                        score += roll1 + roll2 + nextRoll1;
                        return score;
                    }
                } /*Daca nu exista nextRoll1 => game over*/ else {
                    score += roll1 + roll2;
                    return score;
                }
            }
        }
    }
}
