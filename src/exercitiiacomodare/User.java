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
public class User {

    private class TimedPosts {

        private final String post;
        private final long time;

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
    }

    private final String name;
    private final ArrayList<TimedPosts> posts;

    User(String name) {
        this.name = name;
        posts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void getPosts() {
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

    public void addPost(String post, long time) {
        this.posts.add(new TimedPosts(post, time));
    }

}
