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

    public void tweet(String command) {
        boolean hasUser = false;
        int commandId = 0;
        String[] words;
        if (command.contains("->")) {
            words = command.split("->");
            commandId = 1;
        } else if (command.contains("follows")) {
            words = command.split("follows");
            commandId = 2;
        } else {
            words = command.split("wall");
            commandId = 3;
        }
        for (User user : users) {
            if (words[0].contains(user.getName())) {
                hasUser = true;
                if (words.length == 1) {
                    user.getPosts();
                } else {
                    switch (commandId) {
                        case 1:
                            long time = System.nanoTime();
                            user.addPost(words[1], time);
                            break;
                    }

                }
            }
        }

        if (!hasUser) {
            if (words.length == 1) {
                System.out.println("Eror:This user does not exist!"
                        + " Please enter a valid user");
            } else if (commandId == 1) {
                User temp = new User(words[0]);
                long time = System.nanoTime();
                temp.addPost(words[1], time);
                users.add(temp);
            }
        }
    }
}
