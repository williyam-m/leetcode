class Twitter {
    Map<Integer, HashSet<Integer>> followeesMap;
    Map<Integer, PriorityQueue<int[]>> usersFeeds;
    int time;
    public Twitter() {
        followeesMap = new HashMap<>();
        usersFeeds = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        usersFeeds.putIfAbsent(userId, new PriorityQueue<>((a, b) -> b[1] - a[1]));
        usersFeeds.get(userId).offer(new int[] {tweetId, ++time, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feeds = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> followers = followeesMap.get(userId);
        int n = 10;

        if (usersFeeds.get(userId) != null) {
            feeds.addAll(usersFeeds.get(userId));
        }
        if (followers != null) {
            for (Integer follower : followers) {
                if (usersFeeds.get(follower) != null) {
                    feeds.addAll(usersFeeds.get(follower));
                }
            }
        }
        
        while (!feeds.isEmpty() && ans.size() < n) {
            ans.add(feeds.poll()[0]);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followeesMap.putIfAbsent(followerId, new HashSet<>());
        followeesMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followeesMap.get(followerId) == null) {
            return;
        }
        followeesMap.get(followerId).remove(followeeId);
        if (followeesMap.get(followerId).size() == 0) {
            followeesMap.remove(followerId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */