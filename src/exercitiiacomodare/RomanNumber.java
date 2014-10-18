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

    static final float I = 1f;
    static final float V = 5f;
    static final float X = 10f;
    static final float L = 50f;
    static final float C = 100f;
    static final float D = 500f;
    static final float M = 1000f;
    static final float S = 1/2f;
    static final float star = 1/12f;
    private boolean syntaxCheckToggle = true;
    
    public void setSyntaxCheckToggle(boolean b){
        syntaxCheckToggle = b;
    }
    
    public boolean getSyntaxCheckToggle(){
        return syntaxCheckToggle;
    }

    private float getValue(char letter) {
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
            case 'S':
                return S;
            case '*':
                return star;            
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
            case 'S':
                return 7;
            case '*':
                return 8;
           
        }
        return -1;
    }

    private void showCannotSubstractMessage(char c1, char c2) {
        System.err.println("The syntax of the roman number is not valid: cannot substract " + c1 + " from " + c2);
        System.exit(2);
    }

    public void checkRomanNr(String romanNumber) {
        float[] substractOperations = new float[9];
        char currentLetter = romanNumber.charAt(0);
        if(romanNumber.length() > 1){
        char nextLeter = romanNumber.charAt(1);

        float globalMax;

        if (getValue(currentLetter) < getValue(nextLeter)) {
            globalMax = getValue(nextLeter);
            substractOperations[getIndex(nextLeter)] = 1;
        } else {
            globalMax = getValue(currentLetter);
        }

        currentLetter = nextLeter;
        for (int j = 2; j < romanNumber.length(); j++) {
            nextLeter = romanNumber.charAt(j);
            float localMax;
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

        int[] consecLetters = new int[9];
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
            float value = getValue(c);
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
        float decimalNr;
        decimalNr = 0f;
        int j = 0;
        char c2;

        while (j < romanNr.length()) {
            c2 = '0';
            float value1;
            float value2 = -1;
            
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
