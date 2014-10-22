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
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Brindu
 */
public class Twitter {

    private ArrayList<User> users = new ArrayList();
    private int commandId = 0;
    private long startTime = 0;
    String fileWriterName = "Scenario1.out";
    FileWriter fw;

    private String[] processCommand(String command) {
        String[] words;
        if (command.contains("->")) {
            words = command.split("->");
            commandId = 1;
        } else if (command.contains(" follows ")) {
            words = command.split(" follows ");
            commandId = 2;
        } else if (command.contains(" wall")) {
            words = command.split(" wall");
            commandId = 3;
        } else {
            commandId = 0;
            words = command.split("->");
        }
        return words;
    }

    private int getUserId(String name) {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            String nameTest = " " + user.getName() + " ";
            if (nameTest.contains(name)) {
                return i;
            }
        }
        return -1;
    }

    public void tweet(String command) {
        String words[] = processCommand(command);
        String name = " " + words[0] + " ";
        int i = getUserId(name);

        if (i > -1) {
            if (words.length == 1 && commandId != 3) {
                users.get(i).showPersonalPosts();
            } else {
                switch (commandId) {
                    case 1:
                        long time = System.nanoTime();

                        users.get(i).addPost(words[1], time);
                        break;
                    case 2:
                        String name2 = words[1];
                        int j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            System.out.println("The user " + name2
                                    + " does not exist");
                        } else {
                            users.get(i).addFollower(users.get(j));
                        }
                        break;
                    case 3:
                        users.get(i).showWall();
                        break;
                    default:
                        break;
                }
            }
        }

        if (i == -1) {
            if (words.length == 1) {
                System.out.println("The user " + words[0]
                        + " does not exist." + " Please enter a valid user");
            } else if (commandId == 1) {
                User temp = new User(words[0]);

                long time = System.nanoTime();

                temp.addPost(words[1], time);
                users.add(temp);
            }
        }
    }

    public void writeToFile(String command) throws IOException {
        String words[] = processCommand(command);
        String name = " " + words[0] + " ";
        int i = getUserId(name);

        if (i > -1) {
            if (words.length == 1 && commandId != 3) {
                users.get(i).showPersonalPostsToFile(fw);
            } else {
                switch (commandId) {
                    case 1:
                        long time = startTime;
                        startTime += 1;
                        users.get(i).addPost(words[1], time);
                        break;
                    case 2:
                        String name2 = words[1];
                        int j = getUserId(" " + name2 + " ");
                        if (j == -1) {
                            fw.write("The user " + name2
                                    + " does not exist");
                        } else {
                            users.get(i).addFollower(users.get(j));
                        }
                        break;
                    case 3:
                        users.get(i).showWallToFile(fw);
                        break;
                    default:
                        break;
                }
            }
        }
        if (i == -1) {
            if (words.length == 1) {
                fw.write("The user " + words[0]
                        + " does not exist." + " Please enter a valid user");
            } else if (commandId == 1) {
                User temp = new User(words[0]);

                long time = startTime;
                startTime += 1;

                temp.addPost(words[1], time);
                users.add(temp);
            }
        }

    }

    public void readFile(String filename) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(filename));
        fw = new FileWriter(new File(fileWriterName));

        while (true) {
            String s = scanner.nextLine();
            if (s.contains("EXIT")) {
                break;
            } else {
                writeToFile(s);
            }

        }
        fw.flush();
        fw.close();

    }

    public String compareFiles(String filenameOK, String filenameOUT) throws FileNotFoundException {
        Scanner sOK = new Scanner(new File(filenameOK));
        Scanner sOUT = new Scanner(new File(filenameOUT));

        while (sOUT.hasNext()) {
            String s1 = sOK.nextLine();
            String s2 = sOUT.nextLine();

            if (!s2.contains(s1)) {                
                return "Invalid output";
            }
        }
        return "Valid output";
    }
}
