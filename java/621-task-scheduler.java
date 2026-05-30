class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];
        for (char c : tasks) {
            ++freq[c - 'A'];
        }
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }
        while (!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cycle = n + 1;
            int taskCount = 0;
            while (--cycle >= 0 && !maxHeap.isEmpty()) {
                int currFreq = maxHeap.poll();
                if (currFreq > 1) {
                    list.add(currFreq - 1);
                }
                ++taskCount;
            }
            
            for (int l : list) {
                maxHeap.offer(l);
            }
            time += maxHeap.isEmpty() ? taskCount : n + 1;
        }
        return time;
    }
}