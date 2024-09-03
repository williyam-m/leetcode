class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] res = new int[n];
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; ++i) {
            int dis = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            maxHeap.offer(dis);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            res[i] = (maxHeap.size() == k) ? maxHeap.peek() : -1;
        }
        return res;
    }
}