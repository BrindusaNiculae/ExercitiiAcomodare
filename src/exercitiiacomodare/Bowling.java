/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brindu
 */
public class Bowling implements BowlingScoreCalculator {

    private int roll1, roll2 = -1, nextRoll1 = -1, nextRoll2 = -1;
    private int score;
    private int nrOfPerfectRolls;
    private int[] rolls;
    private static int N = 30;

    private int gameNr;

    public void setGameNr(int i) {
        this.gameNr = i;
    }

    Bowling() {
        score = 0;
        nrOfPerfectRolls = 0;
        rolls = new int[N];
        N = 24;
    }

    public int[] readFile(String filename) throws FileNotFoundException {
        int[] vector = new int[N];
        //System.out.println("N = " + N);
        Scanner scanner = new Scanner(new File(filename));
        int i = 0;
        while (scanner.hasNextInt()) {
            vector[i] = scanner.nextInt();
            i++;
        }
        N = i;
        return vector;
    }

    @Override
    public int computeScoreFor(int[] rolls) {

        int i = 1;
        roll1 = rolls[0];
        while (i < N) {
            if (i == N - 4 && roll1 == 10) {
                if (rolls[i + 1] == 10 && rolls[i + 2] == 10 && nrOfPerfectRolls == 6) {
                    return 300;
                }
                return score + rolls[i] + rolls[i + 1] + rolls[i + 2];
               
            } /*STRIKE*/ else if (roll1 == 10) {
                nrOfPerfectRolls++;
                if (nrOfPerfectRolls == 12) {
                    //    System.out.println("If8, jocul " + gameNr);
                    return 300;
                }
                // System.out.println("If1, jocul " + gameNr);

                if ((roll2 != -1) && (nextRoll1 == -1)) {
                    //System.out.println("If3, jocul " + gameNr);
                    nextRoll1 = roll2;
                } else if ((i < N) && (nextRoll1 == -1)) {
                    //   System.out.println("If4, jocul " + gameNr);
                    nextRoll1 = rolls[i++];
                }
                if (i < N) {
                    //   System.out.println("If5, jocul " + gameNr);
                    if (nextRoll2 == -1) {
                        nextRoll2 = rolls[i++];
                    }
                    score += roll1 + nextRoll1 + nextRoll2;
                    roll1 = nextRoll1;
                    roll2 = nextRoll2;
                    nextRoll1 = -1;
                    nextRoll2 = -1;
                }
            } /*Daca am mai multe STRIKE la rand, roll2 va fi 10*/ else {
                /*Daca este SPARE sau OPEN*/
                //System.out.println("If9, jocul " + gameNr);
                if (roll2 == -1) {
                    //   System.out.println("If10, jocul " + gameNr);
                    roll2 = rolls[i++];
                }
                if (i < N) {
                    //    System.out.println("If11, jocul " + gameNr);
                    nextRoll1 = rolls[i++];
                    if (i < N) {
                        //System.out.println("If12, jocul " + gameNr);
                        nextRoll2 = rolls[i++];

                        /*SPARE*/
                        if ((roll1 + roll2) == 10) {
                            //    System.out.println("If13, jocul " + gameNr);
                            score += (roll1 + roll2 + nextRoll1);
                            roll1 = nextRoll1;
                            roll2 = nextRoll2;
                            nextRoll1 = -1;
                            nextRoll2 = -1;
                        } /*OPEN*/ else if ((roll1 + roll2) < 10) {
                            //    System.out.println("If14, jocul " + gameNr);
                            score += (roll1 + roll2);
                            if (i == N ) {
                                return score + nextRoll1 + nextRoll2;
                            }
                            roll1 = nextRoll1;
                            roll2 = nextRoll2;

                            nextRoll1 = -1;
                            nextRoll2 = -1;
                        }
                    } /*Daca nu exista nextRoll2 => game over*/ else {
                        //   System.out.println("If15, jocul " + gameNr);
                        score += roll1 + roll2 + nextRoll1;
                        return score;
                    }
                } /*Daca nu exista nextRoll1 => game over*/ /*Nu ajunge pt ca N= 24*/ else {
                    //    System.out.println("If16, jocul " + gameNr);
                    score += roll1 + roll2;
                    return score;
                }
            }
        }
        //System.out.println("If17, jocul " + gameNr);
        return score;
    }
}
