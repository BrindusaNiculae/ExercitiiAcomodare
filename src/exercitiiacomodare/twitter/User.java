
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare.twitter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Brindu
 */
public class User {

    private final String name;
    private final ArrayList<TimedPosts> posts;
    private ArrayList<TimedPosts> allPosts;
    private final ArrayList<User> followers;
    private long endTime = 550000000;
    private String email = "";
    private String telephone = "";
    private String description = "";
    private ArrayList<TimedPosts> notifications;

    private class TimedPosts implements Comparable<TimedPosts> {

        private final String post;
        private final Long time;

        TimedPosts(String post, long time) {
            this.post = post;
            this.time = time;
        }

        protected String getPost() {
            return post;
        }

        protected long getTime() {
            return time;
        }

        @Override
        public int compareTo(TimedPosts o) {
            return time.compareTo(o.time);
        }

    }

    User(String name) {
        this.name = name;
        posts = new ArrayList<>();
        followers = new ArrayList<>();
        allPosts = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<TimedPosts> getPosts() {
        return posts;
    }

    public void addPost(String post, long time) {
        this.posts.add(new TimedPosts(post, time));
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public String getPhone() {
        return telephone;
    }

    public void setPhone(String tel) {
        telephone = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descr) {
        description = descr;
    }

    public void showPersonalPosts() {
        for (TimedPosts post : posts) {
            long elapsedTimeInSec = (System.nanoTime() - post.getTime()) / 1000000000;
            if (elapsedTimeInSec < 60) {
                int elapsedTime = (int) elapsedTimeInSec;
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " seconds ago)");

            } else {
                int elapsedTime = (int) (elapsedTimeInSec / 60);
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " minutes ago)");
            }
        }
    }

    public void showWall() {
        allPosts = new ArrayList<TimedPosts>();

        for (int i = 0; i < this.posts.size(); i++) {
            String newPost = this.name + ": " + this.posts.get(i).getPost();
            Long time = posts.get(i).getTime();
            allPosts.add(new TimedPosts(newPost, time));
        }

        for (User follower : followers) {
            for (TimedPosts post : follower.getPosts()) {
                String newPost = follower.getName() + ": " + post.getPost();
                Long time = post.getTime();
                allPosts.add(new TimedPosts(newPost, time));
            }
        }
        Collections.sort(allPosts, new Comparator<TimedPosts>() {

            @Override
            public int compare(TimedPosts o1, TimedPosts o2) {
                return (int) ((o1.time - o2.time) / 1000000000);
            }
        });

        for (TimedPosts post : allPosts) {
            long elapsedTimeInSec = (System.nanoTime() - post.getTime()) / 1000000000;
            if (elapsedTimeInSec < 60) {
                int elapsedTime = (int) elapsedTimeInSec;
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " seconds ago)");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / 60);
                System.out.println(post.getPost() + "(" + elapsedTime
                        + " minutes ago)");

            }
        }
    }

    public void showProfileToFile(FileWriter f) throws IOException, ProfileNotSetException {
        if (this.getEmail() == "" || this.getPhone() == ""
                || this.getDescription() == "") {
            f.write("User " + this.getName() + " does not have any info set.\n");
        } else {
            f.write("User " + this.getName() + " has the following info:\n");
            f.write("    -Email: " + this.getEmail());
            f.write("\n    -Telephone nr: " + this.getPhone());
            f.write("\n    -Description: " + this.getDescription());
            f.write("\n");
        }
    }

    public void editProfile(String mail, String tel, String desc) {
        this.setEmail(mail);
        this.setPhone(tel);
        this.setDescription(desc);
    }

    public void showWallToFile(FileWriter f) throws IOException {
        allPosts = new ArrayList<TimedPosts>();

        for (int i = 0; i < this.posts.size(); i++) {
            String newPost = this.name + ": " + this.posts.get(i).getPost();
            Long time = posts.get(i).getTime();
            allPosts.add(new TimedPosts(newPost, time));

        }

        for (User follower : followers) {
            for (TimedPosts post : follower.getPosts()) {
                String newPost = follower.getName() + ": " + post.getPost();
                Long time = post.getTime();
                allPosts.add(new TimedPosts(newPost, time));
            }
        }
        Collections.sort(allPosts, new Comparator<TimedPosts>() {

            @Override
            public int compare(TimedPosts o1, TimedPosts o2) {
                return (int) ((o1.time - o2.time));
            }
        });

        for (TimedPosts post : allPosts) {
            long elapsedTimeInSec = (endTime - post.getTime()) / 1000000000;
            endTime += 1000000000;
            if (elapsedTimeInSec < 60) {
                int elapsedTime = (int) elapsedTimeInSec;
                f.write(post.getPost() + "(" + elapsedTime
                        + " seconds ago)\n");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / 60);
                f.write(post.getPost() + "(" + elapsedTime
                        + " minutes ago)\n");
            }
        }
    }

    public void showPersonalPostsToFile(FileWriter f) throws IOException {
        for (TimedPosts post : posts) {
            long elapsedTimeInSec = (endTime - post.getTime()) / 1000000000;
            endTime += 1000000000;
            if (elapsedTimeInSec < 60) {
                int elapsedTime = (int) elapsedTimeInSec;
                f.write(post.getPost() + "(" + elapsedTime
                        + " seconds ago)\n");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / 60);
                f.write(post.getPost() + "(" + elapsedTime
                        + " minutes ago)\n");
            }
        }
    }

    public void showNotificationsToFile(FileWriter f) throws IOException {

        for (TimedPosts post : notifications) {
            long elapsedTimeInSec = (endTime - post.getTime()) / 1000000000;
            endTime += 1000000000;
            if (elapsedTimeInSec < 60) {
                int elapsedTime = (int) elapsedTimeInSec;
                f.write(post.getPost() + "(" + elapsedTime
                        + " seconds ago)\n");
            } else {
                int elapsedTime = (int) (elapsedTimeInSec / 60);
                f.write(post.getPost() + "(" + elapsedTime
                        + " minutes ago)\n");
            }
        }
    }

    public void addNotification(String post, long time) {
        this.notifications.add(new TimedPosts(post, time));
    }

    public void getPeopleYouMightKnowToFile(FileWriter f) throws IOException {
        ArrayList<String> ppl = new ArrayList<>();
        for (User user : followers) {
            if (user.getFollowers().size() == 0) {
                ppl.add("The user: " + user.getName() + " doesn't follow anybody.\n");
            } else {
                for (User personYouMightKnow : user.getFollowers()) {
                    if (!personYouMightKnow.getName().equals(this.getName())) {
                        boolean alreadyAdded = false;
                        for (String aux : ppl) {
                            if (aux.contains(personYouMightKnow.getName())) {
                                alreadyAdded = true;
                            }
                        }
                        if (!alreadyAdded) {
                            ppl.add("You might know: " + personYouMightKnow.getName() + ".\n");
                        }
                    }
                }
            }
        }
        f.write("Dear " + this.getName() + ":\n");
        for (String s : ppl) {
            f.write(s);
        }

    }

}
