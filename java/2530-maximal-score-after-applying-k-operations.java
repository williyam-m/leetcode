class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (int n : nums)
            maxHeap.offer(n);

        while (k-- > 0) {
            ans += maxHeap.peek();
            maxHeap.offer((maxHeap.poll() + 2) / 3);
        }
        return ans;
    }
}