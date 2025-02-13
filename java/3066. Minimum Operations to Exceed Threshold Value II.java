class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0;
        for (int num : nums) {
            pq.offer((long) num);
        }

        while (pq.size() > 1) {
            if (pq.peek() >= k)
               break;
            pq.add((pq.poll() * 2) + pq.poll());
        }

        return nums.length - pq.size();
    }
}