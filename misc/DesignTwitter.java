package misc;

// leetcode #355

import java.util.*;

class Tweet{
    int tweetId;
    int userId;
    Tweet(int id,int num){
        tweetId = id;
        userId = num;
    }
}


public class DesignTwitter {
    private Map<Integer,Set<Integer>> following;
    private ArrayList<Tweet> tweets;
    public DesignTwitter() {
        tweets = new ArrayList<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!following.containsKey(userId))
            following.put(userId,new HashSet<>());
        tweets.add(0,new Tweet(tweetId,userId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recentTweets = new ArrayList<>();
        for(Tweet tweet:tweets){
            if(tweet.userId == userId || following.get(userId).contains(tweet.userId))
                recentTweets.add(tweet.tweetId);
            if(recentTweets.size() == 10) break;
        }
        return recentTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId,new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            if(following.get(followerId).contains(followeeId))
                following.get(followerId).remove(followeeId);
        }
    }
}
