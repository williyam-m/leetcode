class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.merge(num, 1, Integer::sum);

        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            minHeap.offer(new Pair<>(m.getKey(), m.getValue()));
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] ans = new int[k];
        for (Pair<Integer, Integer> heap : minHeap)
            ans[--k] = heap.getKey();
        return ans;
    }
}