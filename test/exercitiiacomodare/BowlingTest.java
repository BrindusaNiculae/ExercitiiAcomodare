/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brindu
 */
public class BowlingTest {

    public BowlingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of computeScoreFor method, of class Bowling.
     */

    @Test
    public void testComputeScoreForGame1() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game1.txt");
        int expResult = 20;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame2() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game2.txt");
        int expResult = 0;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame3() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game3.txt");
        int expResult = 300;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame4() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game4.txt");
        int expResult = 16;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame5() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game5.txt");
        int expResult = 24;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame6() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game6.txt");
        int expResult = 69;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame7() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game7.txt");
        int expResult = 79;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame8() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game8.txt");
        int expResult = 112;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame9() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game9.txt");
        int expResult = 104;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame10() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game10.txt");
        int expResult = 215;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame11() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game11.txt");
        int expResult = 243;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame12() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game12.txt");
        int expResult = 201;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame13() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game13.txt");
        int expResult = 143;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame14() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game14.txt");
        int expResult = 115;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame15() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game15.txt");
        int expResult = 159;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame16() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game16.txt");
        int expResult = 135;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    @Test
    public void testComputeScoreForGame17() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game17.txt");
        int expResult = 77;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

}
