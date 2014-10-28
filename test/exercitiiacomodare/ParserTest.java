/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.internal.runners.TestClass;

/**
 *
 * @author Brindu
 */
public class ParserTest {

    public ParserTest() {
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
     * Test of parse method, of class Parser.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
//        String filename = "tranzactii_selectate_pentru_parser.csv";
//        Parser instance = new Parser();
//        instance.parse(filename);

        Scanner sOK = new Scanner(new File("ParsingCSV.ok"));
        Scanner sOUT = new Scanner(new File("parse.out"));

        while (sOUT.hasNext()) {
            String s1 = sOK.nextLine();
            String s2 = sOUT.nextLine();

            assertEquals(s2, s1);
        }

    }
}
