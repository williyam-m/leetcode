class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            }
            else {
                freq.put(num, 1);
            }
        }
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int i = k - 1; i >= 0; --i) {
            ans[i] = minHeap.poll()[0];
        }
        return ans;
    }
}