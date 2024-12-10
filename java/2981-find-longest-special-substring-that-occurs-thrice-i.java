class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Queue[] minHeap = new Queue[26];
        for (int i = 0; i < 26; ++i) {
            minHeap[i] = new PriorityQueue<Integer>();
        }
        int count = 1;
        for (int i = 0; i < n - 1; ++i) {
            char c = s.charAt(i);
            if (s.charAt(i) != s.charAt(i + 1)) {
                for (int j = 0; j < 3; ++j) {
                    if (count >= 3 - j) {
                        minHeap[c - 'a'].offer(count--);
                        if (minHeap[c - 'a'].size() > 3)
                            minHeap[c - 'a'].poll();
                    }
                }
                count = 1;
            }
            else 
               ++count;
        }
        char c = s.charAt(n - 1);
        for (int j = 0; j < 3; ++j) {
            if (count >= 3 - j) {
                minHeap[c - 'a'].offer(count--);
                if (minHeap[c - 'a'].size() > 3)
                    minHeap[c - 'a'].poll();
            }
        }

        int ans = -1;
        for (int i = 0; i < 26; ++i) {
            if (minHeap[i].size() >= 3) {
               ans = Math.max(ans, (int) minHeap[i].poll());
            }
        }
        return ans;
    }
}