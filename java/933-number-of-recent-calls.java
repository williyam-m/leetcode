class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        int n = queue.size();
        for (int q : queue) {
            if (q >= t - 3000)
               break;
            --n;
        }
        return n;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */