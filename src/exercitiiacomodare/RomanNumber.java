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
public class RomanNumber {

    static final int I = 1;
    static final int V = 5;
    static final int X = 10;
    static final int L = 50;
    static final int C = 100;
    static final int D = 500;
    static final int M = 1000;
    static final int E = 5000;
    private boolean syntaxCheckToggle = true;
    
    public void setSyntaxCheckToggle(boolean b){
        syntaxCheckToggle = b;
    }
    
    public boolean getSyntaxCheckToggle(){
        return syntaxCheckToggle;
    }

    private int getValue(char letter) {
        switch (letter) {
            case 'I':
                return I;
            case 'V':
                return V;
            case 'X':
                return X;
            case 'L':
                return L;
            case 'C':
                return C;
            case 'D':
                return D;
            case 'M':
                return M;
            case 'E':
                return E;
        }
        return -1;
    }

    private int getIndex(char letter) {
        switch (letter) {
            case 'I':
                return 0;
            case 'V':
                return 1;
            case 'X':
                return 2;
            case 'L':
                return 3;
            case 'C':
                return 4;
            case 'D':
                return 5;
            case 'M':
                return 6;
            case 'E':
                return 7;
        }
        return -1;
    }

    private void showCannotSubstractMessage(char c1, char c2) {
        System.err.println("The syntax of the roman number is not valid: cannot substract " + c1 + " from " + c2);
        System.exit(2);
    }

    public void checkRomanNr(String romanNumber) {
        int[] substractOperations = new int[8];
        char currentLetter = romanNumber.charAt(0);
        if(romanNumber.length() > 1){
        char nextLeter = romanNumber.charAt(1);

        int globalMax;

        if (getValue(currentLetter) < getValue(nextLeter)) {
            globalMax = getValue(nextLeter);
            substractOperations[getIndex(nextLeter)] = 1;
        } else {
            globalMax = getValue(currentLetter);
        }

        currentLetter = nextLeter;
        for (int j = 2; j < romanNumber.length(); j++) {
            nextLeter = romanNumber.charAt(j);
            int localMax;
            if (getValue(currentLetter) < getValue(nextLeter)) {
                localMax = getValue(nextLeter);
                if (substractOperations[getIndex(nextLeter)] == 1) {
                    System.err.println("The syntax of the roman number is not valid.");
                    System.exit(2);
                }
                substractOperations[getIndex(nextLeter)] = 1;
            } else {
                localMax = getValue(currentLetter);
            }

            if (localMax > globalMax) {
                System.err.println("The syntax of the roman number is not valid.");
                System.exit(2);
            }
            currentLetter = nextLeter;
            globalMax = localMax;
        }
        }
    }

    private void checkValidSubstraction(char c1, char c2) {
        int index1 = getIndex(c1);
        int index2 = getIndex(c2);

        if ((index2 % 2) == 0) {
            if ((index2 - index1) > 2) {
                showCannotSubstractMessage(c1, c2);
            }
        } else {
            if ((index2 - index1) > 1) {
                showCannotSubstractMessage(c1, c2);
            }
        }
    }

    private void checkThreeConsecLetters(String number) {

        int[] consecLetters = new int[8];
        for (char c : number.toCharArray()) {
            consecLetters[getIndex(c)]++;
            if (consecLetters[getIndex(c)] > 3) {
                System.err.println("The syntax of the roman number is not valid: you can only have 3 maximum consecutive letters of " + c);
                System.exit(2);
            }
        }
    }

    private void checkValidLetters(String number) {
        for (char c : number.toCharArray()) {
            int value = getValue(c);
            if (value < 0) {
                System.err.println("Invalid letter");
                System.exit(1);
            }
        }
    }

    public void transform(String romanNr) {
        checkValidLetters(romanNr);

        if (syntaxCheckToggle) {
            checkRomanNr(romanNr);
            checkThreeConsecLetters(romanNr);
        }
        int decimalNr = 0;
        int j = 0;
        char c2;

        while (j < romanNr.length()) {
            c2 = '0';
            int value2 = -1;
            int value1;
            char c1 = romanNr.charAt(j);
            value1 = getValue(c1);

            j++;
            if (j < romanNr.length()) {
                c2 = romanNr.charAt(j);
                value2 = getValue(c2);
            }

            if (value1 >= value2) {
                decimalNr += value1;
            } else {
                if (syntaxCheckToggle) {
                    checkValidSubstraction(c1, c2);
                }
                decimalNr += (value2 - value1);
                j++;
            }
        }
        System.out.println("Your decimal number is: " + decimalNr);
        System.exit(0);
    }
}
