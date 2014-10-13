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

    public int transform(String romanNr) {
        int decimalNr = 0;
        int i = 0, aux;
        char c2 = 'A';

        while (i < romanNr.length()) {
            aux = 0;
            char c1 = romanNr.charAt(i);
            i++;
            if (i < romanNr.length()) {
                c2 = romanNr.charAt(i);
            }

            switch (c1) {
                case 'M':
                    decimalNr += M;
                    break;
                case 'D':
                    switch (c2) {
                        case 'M':
                            i++;
                            decimalNr += (M - D);
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

                        default:
                            decimalNr += I;
                            break;
                    }
                    break;
            }
        }

        return decimalNr;
    }

}
