/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

import java.util.ArrayList;

/**
 *
 * @author Brindu
 */
public class Twitter {

    private ArrayList<User> users = new ArrayList();
    private int commandId = 0;

    private String[] processCommand(String command) {
        String[] words;
        if (command.contains("->")) {
            words = command.split("->");
            commandId = 1;
        } else if (command.contains("follows")) {
            words = command.split("follows");
            commandId = 2;
        } else if (command.contains("wall")) {
            words = command.split("wall");
            commandId = 3;
        } else {
            commandId = 0;
            words = command.split(" ");
        }
        return words;
    }

    private int getUserId(String name) {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (name.contains(" " + user.getName() + " ")) {
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
                        + "does not exist." + " Please enter a valid user");
            } else if (commandId == 1) {
                User temp = new User(words[0]);
                long time = System.nanoTime();
                temp.addPost(words[1], time);
                users.add(temp);
            }
        }
    }
}
