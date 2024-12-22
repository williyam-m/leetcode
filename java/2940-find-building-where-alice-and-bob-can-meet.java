class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        List<List<int[]>> diff = new ArrayList<>();
        for (int i = 0; i < n; ++i)
           diff.add(new ArrayList<>());
        
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        for (int i = 0; i < q; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b || heights[a] < heights[b])
               ans[i] = b;
            else
               diff.get(b).add(new int[] {heights[a], i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n; ++i) {
            for (int[] d : diff.get(i))
                pq.offer(d);
            while (!pq.isEmpty() && pq.peek()[0] < heights[i])
               ans[pq.poll()[1]] = i;
        }
        return ans;
    }
}