package day29;

import java.util.*;

/**
 * @author Heng Yu
 * @date 4/2/20 9:26 PM
 */

/**
 * leetcode 355: Design Twitter
 */

public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
    }

    private static class Info {
        Set<Integer> follows;
        List<Integer> posts;

        public Info(int userId) {
            this.posts = new ArrayList<>();
            this.follows = new HashSet<>();
            this.follows.add(userId);
        }
    }

    private Map<Integer, Info> users;
    private Set<Integer> tweets;
    private Map<Integer, Integer> db;
    private int index;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.users = new HashMap<>();
        this.tweets = new HashSet<>();
        this.db = new HashMap<>();
        this.index = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.contains(tweetId)) {
            if (!users.containsKey(userId)) {
                users.put(userId, new Info(userId));
            }
            tweets.add(tweetId);
            db.put(++index, tweetId);
            Info user = users.get(userId);
            user.posts.add(index);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) return new ArrayList<>();
        List<Integer> allFeeds = new ArrayList<>();
        Set<Integer> follows = users.get(userId).follows;
        for (int i : follows) {
            allFeeds.addAll(users.get(i).posts);
        }
        allFeeds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < allFeeds.size(); ++i) {
            if (i == 10) break;
            ret.add(db.get(allFeeds.get(i)));
        }
        return ret;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new Info(followerId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new Info(followeeId));
        }
        users.get(followerId).follows.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && users.containsKey(followerId) && users.containsKey(followeeId)) {
            Info user = users.get(followerId);
            if (user.follows.contains(followeeId)) {
                user.follows.remove(followeeId);
            }
        }
    }
}
