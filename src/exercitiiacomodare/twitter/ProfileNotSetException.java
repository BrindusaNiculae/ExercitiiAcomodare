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
class ProfileNotSetException extends Exception {

    public ProfileNotSetException() {
        System.err.println("The profile for this user is not set!");
    }

}
