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
class InvalidUserException extends Exception {

    String name;

    InvalidUserException(String name) {
        this.name = name;
        System.err.println("Invalid user " + name
                + " please enter a valid user");
    }

    public InvalidUserException() {
        System.err.println("Invalid user " + name
                + " please enter a valid user");

    }

}
