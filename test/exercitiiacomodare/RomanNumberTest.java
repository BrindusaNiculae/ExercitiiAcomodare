/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import junit.framework.TestCase;

/**
 *
 * @author Brindu
 */
public class RomanNumberTest extends TestCase {
    
    public RomanNumberTest(String testName) {
        super(testName);
    }

    /**
     * Test of setSyntaxCheckToggle method, of class RomanNumber.
     */
    public void testSetSyntaxCheckToggle() {
        System.out.println("setSyntaxCheckToggle");
        boolean b = false;
        RomanNumber instance = new RomanNumber();
        instance.setSyntaxCheckToggle(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSyntaxCheckToggle method, of class RomanNumber.
     */
    public void testGetSyntaxCheckToggle() {
        System.out.println("getSyntaxCheckToggle");
        RomanNumber instance = new RomanNumber();
        boolean expResult = false;
        boolean result = instance.getSyntaxCheckToggle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRomanNr method, of class RomanNumber.
     */
    public void testCheckRomanNr() {
        System.out.println("checkRomanNr");
        String romanNumber = "";
        RomanNumber instance = new RomanNumber();
        boolean expResult = false;
        boolean result = instance.checkRomanNr(romanNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGeneralCheck method, of class RomanNumber.
     */
    public void testDoGeneralCheck() {
        System.out.println("doGeneralCheck");
        String romanNr = "";
        RomanNumber instance = new RomanNumber();
        instance.doGeneralCheck(romanNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class RomanNumber.
     */
    public void testTransform() {
        System.out.println("transform");
        String romanNr = "";
        RomanNumber instance = new RomanNumber();
        instance.transform(romanNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
