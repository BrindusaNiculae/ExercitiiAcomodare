/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare.twitter;

/**
 *
 * @author Brindu
 */
class InvalidMailFormatException extends Exception {

    public InvalidMailFormatException() {
        System.err.println("The format of the email is invalid. "
                + "Enter a valid email address");
        return;
    }
    
}
