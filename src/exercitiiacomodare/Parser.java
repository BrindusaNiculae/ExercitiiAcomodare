/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Parser {

    String fileWriterName = "parse.out";
    FileWriter f;

    private final HashMap<String, Integer> getMonth = new HashMap<String, Integer>() {
        {
            put("ianuarie", 1);
            put("februarie", 2);
            put("martie", 3);
            put("aprilie", 4);
            put("mai", 5);
            put("iunie", 6);
            put("iulie", 7);
            put("august", 8);
            put("septembrie", 9);
            put("octombrie", 10);
            put("noiembrie", 11);
            put("decembrie", 12);
        }
    };

    private String getStringToParse(Scanner sc) {
        String s = sc.next();
        String aux = "";

        aux += s + " ";
        while (getMonth.get(s) == null && sc.hasNext()) {

            s = sc.next();
            aux += s + " ";
        }
        return aux;
    }

    public void parse(String filename) throws FileNotFoundException, IOException,
            InvalidInputException {

        Scanner scanner = new Scanner(new File(filename));
        f = new FileWriter(new File(fileWriterName));
        int month, n, m;
        String day, year, name, money;
        boolean hasMoney;
        String[] finalOutput;
        String s = scanner.nextLine();

        if (scanner.hasNext()) {
            day = scanner.next();
        } else {
            throw new InvalidInputException();
        }
        if (scanner.hasNext()) {
            month = getMonth.get(scanner.next());
        } else {
            throw new InvalidInputException();
        }

        while (scanner.hasNext()) {
            finalOutput = new String[20];
            name = "";
            money = "";
            hasMoney = false;
            m = 0;
            s = this.getStringToParse(scanner);            
            String[] words = s.split(",");
            year = words[0];
            /*Scriu primul camp*/
            f.write("\"" + year + "-" + month + "-" + day + "\"");
            day = words[words.length - 1].trim();

            f.write(",\"");
            if (scanner.hasNext()) {
                n = words.length - 1;
            } else {
                n = words.length;
            }

            for (int i = 1; i < n; i++) {
                if (words[i].contains("Ordonator")) {
                    String[] aux = words[i].split(":");
                    name = aux[1].trim();
                    finalOutput[m++] = words[i].trim();                    
                } else if (words[i].matches(".*\\d+.*") && words[i].contains("\"")
                        && !words[i].contains(":") && !hasMoney) {
                    if (money.equals("")) {
                        money += words[i].trim();
                    } else {
                        money += "." + words[i].trim();
                        hasMoney = true;
                    }
                } else if (!words[i].equals("") && !words[i].equals(" ")) {
                   finalOutput[m++] = words[i].trim();
                }
            }
            /*Scriu al 2-lea camp */            
            for(int i = 0; i < m-1; i++){
                f.write(finalOutput[i] + "||");
            }
            f.write(finalOutput[m-1]);
            f.write("\",");
            /*Scriu al 3-lea acamp*/
            f.write(money);
            /*Scriu al 4-lea camp*/
            f.write(",\"" + name + "\"\n");
        }
        f.flush();
        f.close();
    }

    public void copyFile(String filename) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(filename));
        FileWriter fw = new FileWriter(new File("copy.txt"));

        while (scanner.hasNext()) {
            fw.write(" " + scanner.next());
            fw.write("\n");
        }

        fw.flush();
        fw.close();

    }

}
