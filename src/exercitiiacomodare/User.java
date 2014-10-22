
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercitiiacomodare;

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

    public ArrayList<User> getFollowes() {
        return followers;
    }

    public void addFollower(User user) {
        followers.add(user);
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
            long elapsedTimeInSec = (System.nanoTime() - post.getTime()) / 1000000000;
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
}
