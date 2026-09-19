class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = 1_000_000_000 + 7;

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }

        for (int[] road : roads) {
            graph[road[0]].add(new int[] {road[1], road[2]});
            graph[road[1]].add(new int[] {road[0], road[2]});
        }

        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        pq.add(new long[] {0, 0});
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            int pos = (int) pq.peek()[0];
            long time = pq.poll()[1];

            for (int[] next : graph[pos]) {
                int nextPos = next[0];
                long nextTime = time + next[1];

                if (dist[nextPos] > nextTime) {
                    pq.add(new long[] {nextPos, nextTime});
                    dist[nextPos] = nextTime;
                    ways[nextPos] = ways[pos];
                }
                else if (dist[nextPos] == nextTime) {
                    ways[nextPos] = (int) ((long) (ways[nextPos] + ways[pos])) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}