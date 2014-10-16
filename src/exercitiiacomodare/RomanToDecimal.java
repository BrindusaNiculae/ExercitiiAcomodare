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

    private static final int I = 1;
    private static final int V = 5;
    private static final int X = 10;
    private static final int L = 50;
    private static final int C = 100;
    private static final int D = 500;
    private static final int M = 1000;
    private static final int E = 5000;

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

    
    private int getIndex(char letter){
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
    
    
    public void checkRomanNumber(String romanNumber){
        int[] substractOperations=new int[8];
        char currentLetter=romanNumber.charAt(0);
        char nextLetter=romanNumber.charAt(1);
        
        int globalMax;
        
        if(getValue(currentLetter)<getValue(nextLetter)){
            globalMax=getValue(nextLetter);
            substractOperations[getIndex(nextLetter)]=1;
        }else{
            globalMax=getValue(currentLetter);
        }
        
        currentLetter=nextLetter;
        for(int i=2;i<romanNumber.length();i++){
            nextLetter=romanNumber.charAt(i);
            int localMax;
            if(getValue(currentLetter)<getValue(nextLetter)){
                localMax=getValue(nextLetter);
                if(substractOperations[getIndex(nextLetter)]==1){
                    System.err.println("The syntax of the roman number is not valid.");
                    System.exit(2);
                }
                substractOperations[getIndex(nextLetter)]=1;
            }else{
                localMax=getValue(currentLetter);
            }
            
            if(localMax>globalMax){
                System.err.println("The syntax of the roman number is not valid.");
                System.exit(2);
            }
            currentLetter=nextLetter;
            globalMax=localMax;
        }
        
    
    }
    
    
    public void transform(String romanNr) {
        
        int decimalNr = 0;
        int i = 0, aux, statusCode = 0;
        char c2 = 'A';

        while ((i < romanNr.length()) && (statusCode == 0)) {
            aux = 0;
            char c1 = romanNr.charAt(i);
            i++;
            if (i < romanNr.length()) {
                c2 = romanNr.charAt(i);
            }
            switch (c1) {
                case 'E':
                    decimalNr += E;
                    break;
                case 'M':
                    switch (c2) {
                        case 'E':
                            i++;
                            decimalNr += (E - M);
                            break;
                        default:
                            decimalNr += M;
                            break;
                    }
                    break;
                case 'D':
                    switch (c2) {
                        case 'M':
                            i++;
                            decimalNr += (M - D);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - D);
                            break;
                        default:
                            decimalNr += D;
                            break;
                    }
                    break;
                case 'C':
                    switch (c2) {
                        case 'D':
                            i++;
                            decimalNr += (D - C);
                            break;
                        case 'M':
                            i++;
                            decimalNr += (M - C);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - C);
                            break;
                        default:
                            decimalNr += C;
                            break;
                    }
                    break;
                case 'L':
                    switch (c2) {
                        case 'C':
                            i++;
                            decimalNr += (C - L);
                            break;
                        case 'D':
                            i++;
                            decimalNr += (D - L);
                            break;
                        case 'M':
                            i++;
                            decimalNr += (M - L);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - L);
                            break;
                        default:
                            decimalNr += L;
                            break;
                    }
                    break;
                case 'X':
                    switch (c2) {
                        case 'L':
                            i++;
                            decimalNr += (L - X);
                            break;
                        case 'C':
                            i++;
                            decimalNr += (C - X);
                            break;
                        case 'D':
                            i++;
                            decimalNr += (D - X);
                            break;
                        case 'M':
                            i++;
                            decimalNr += (M - X);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - X);
                            break;
                        default:
                            decimalNr += X;
                            break;
                    }
                    break;
                case 'V':
                    switch (c2) {
                        case 'X':
                            i++;
                            decimalNr += (X - V);
                            break;
                        case 'L':
                            i++;
                            decimalNr += (L - V);
                            break;
                        case 'C':
                            i++;
                            decimalNr += (C - V);
                            break;
                        case 'D':
                            i++;
                            decimalNr += (D - V);
                            break;
                        case 'M':
                            i++;
                            decimalNr += (M - V);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - V);
                            break;
                        default:
                            decimalNr += V;
                            break;
                    }
                    break;
                case 'I':
                    switch (c2) {
                        case 'V':
                            i++;
                            decimalNr += (V - I);
                            break;
                        case 'X':
                            i++;
                            decimalNr += (X - I);
                            break;
                        case 'L':
                            i++;
                            decimalNr += (L - I);
                            break;
                        case 'C':
                            i++;
                            decimalNr += (C - I);
                            break;
                        case 'D':
                            i++;
                            decimalNr += (D - I);
                            break;
                        case 'M':
                            i++;
                            decimalNr += (M - I);
                            break;
                        case 'E':
                            i++;
                            decimalNr += (E - I);
                            break;
                        default:
                            decimalNr += I;
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

        
        checkRomanNumber(romanNr);
        System.out.println("Your decimal number is: " + decimalNr);
        System.exit(statusCode);
        //return decimalNr;
    }
}
