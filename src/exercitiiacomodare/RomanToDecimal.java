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
public class RomanToDecimal {

    static final int I = 1;
    static final int V = 5;
    static final int X = 10;
    static final int L = 50;
    static final int C = 100;
    static final int D = 500;
    static final int M = 1000;
    static final int E = 5000;

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

    public void checkRomanNr(String romanNumber) {
        int[] substractOperations = new int[8];
        char currentLetter = romanNumber.charAt(0);
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

    private void showCannotSubstractMessage(char c1, char c2) {
        System.err.println("The syntax of the roman number is not valid: cannot substract " + c1 + " from " + c2);
        System.exit(2);
    }

    
    private void checkThreeConsecLetters(String number){
        
        int[] consecLetters = new int[8];
        for(char c:number.toCharArray()){
            consecLetters[getIndex(c)]++;
            if(consecLetters[getIndex(c)]>3){
                System.err.println("The syntax of the roman number is not valid: you can only have 3 maximum consecutive letters of " + c);
                System.exit(2);
            }
        }
    }

    public void transform(String romanNr) {

        int decimalNo = 0;
        int j = 0, statusCode = 0;
        char c2 = 'A';
        checkThreeConsecLetters(romanNr);
        
        while ((j < romanNr.length()) && (statusCode == 0)) {
            c2 = 'A';
            
            char c1 = romanNr.charAt(j);
            j++;
            if (j < romanNr.length()) {
                c2 = romanNr.charAt(j);
                
            }
            switch (c1) {
                case 'E':
                    decimalNo += E;
                    break;
                case 'M':
                    switch (c2) {
                        case 'E':
                            j++;
                            decimalNo += (E - M);
                            break;
                        default:
                            decimalNo += M;
                            break;
                    }
                    break;
                case 'D':
                    switch (c2) {
                        case 'M':
                            j++;
                            decimalNo += (M - D);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - D);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += D;
                            break;
                    }
                    break;
                case 'C':
                    switch (c2) {
                        case 'D':
                            j++;
                            decimalNo += (D - C);
                            break;
                        case 'M':
                            j++;
                            decimalNo += (M - C);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - C);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += C;
                            break;
                    }
                    break;
                case 'L':
                    switch (c2) {
                        case 'C':
                            j++;
                            decimalNo += (C - L);
                            break;
                        case 'D':
                            j++;
                            //decimalNo += (D - L);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'M':
                            j++;
                            //decimalNo += (M - L);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - L);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += L;
                            break;
                    }
                    break;
                case 'X':
                    switch (c2) {
                        case 'L':
                            j++;
                            decimalNo += (L - X);
                            break;
                        case 'C':
                            j++;
                            decimalNo += (C - X);
                            break;
                        case 'D':
                            j++;
                            //decimalNo += (D - X);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'M':
                            j++;
                            //decimalNo += (M - X);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - X);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += X;
                            break;
                    }
                    break;
                case 'V':
                    switch (c2) {
                        case 'X':
                            j++;
                            decimalNo += (X - V);
                            break;
                        case 'L':
                            j++;
                            //decimalNo += (L - V);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'C':
                            j++;
                            //decimalNo += (C - V);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'D':
                            j++;
                            //decimalNo += (D - V);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'M':
                            j++;
                            //decimalNo += (M - V);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - V);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += V;
                            break;
                    }
                    break;
                case 'I':
                    switch (c2) {
                        case 'V':
                            j++;
                            decimalNo += (V - I);
                            break;
                        case 'X':
                            j++;
                            decimalNo += (X - I);
                            break;
                        case 'L':
                            j++;
                            //decimalNo += (L - I);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'C':
                            j++;
                            //decimalNo += (C - I);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'D':
                            j++;
                            //decimalNo += (D - I);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'M':
                            j++;
                            //decimalNo += (M - I);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        case 'E':
                            j++;
                            //decimalNo += (E - I);
                            showCannotSubstractMessage(c1, c2);
                            break;
                        default:
                            decimalNo += I;
                            break;
                    }
                    break;
                default:
                    statusCode = 1;
                    System.err.print("Numarul este invalid\n");
                    System.exit(statusCode);
                //break;
            }
        }

        checkRomanNr(romanNr);
        System.out.println("Your decimal number is: " + decimalNo);
        System.exit(statusCode);
        //return decimalNr;
    }
}
