/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

/**
 *
 * @author Brindu
 */
class InvalidInputException extends Exception {

    public InvalidInputException() {
        System.err.println("The input file is not valid.");
    }
    
}
