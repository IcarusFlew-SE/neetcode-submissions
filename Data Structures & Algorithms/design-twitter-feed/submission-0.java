class Twitter {
    private Map<Integer, List<Integer>> userTweets;
    private Map<Integer, Set<Integer>> userFollow;
    private Map<Integer, Integer> tweetTimestamp;
    //current timestamp
    private int timestamp = 0;

    public Twitter() {
        userTweets = new HashMap<>();
        // Users can only follow one and only one
        userFollow = new HashMap<>();
        tweetTimestamp = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // Check if exist, if not new tweetId
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
        // store post id, increment timestamp for recent
        tweetTimestamp.put(tweetId, ++timestamp);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Get latest tweet from heap - PQ, inserted from the map
        Set<Integer> following = userFollow.getOrDefault(userId, new HashSet<>());
        Set<Integer> allRelevantUsers = new HashSet<>(following);
        allRelevantUsers.add(userId);
        // Most recent to oldest - tweets sorted via timestamp 
        PriorityQueue<Integer> tweetQueue = new PriorityQueue<>(
            (tweet1, tweet2) -> tweetTimestamp.get(tweet2) - tweetTimestamp.get(tweet1)
        );

        for (Integer currentUserId : allRelevantUsers) {
            List<Integer> currentUserTweets = userTweets.get(currentUserId);

            if (currentUserTweets != null && !currentUserTweets.isEmpty()) {
                int tweetsToAdd = Math.min(10, currentUserTweets.size());
                    for (int i = currentUserTweets.size() - 1;
                        i >= currentUserTweets.size() - tweetsToAdd; i--) {
                            tweetQueue.offer(currentUserTweets.get(i));
                        }
            }
        }
        // Extract top 10 newsFeed from the tweetQueue
        List<Integer> newsFeed = new ArrayList<>();
        while (!tweetQueue.isEmpty() && newsFeed.size() < 10) { // while-loop to iterate through all the relevant users newsfeed
            newsFeed.add(tweetQueue.poll());
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        // Iterate through and matching the same id, store to another map post follow
        // No duplicates, and check existing if not add to map
        userFollow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Same as follow, but delete-remove from stored 
        userFollow.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}
