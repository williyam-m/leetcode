class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            g[x].add(new int[] {y, w});
            g[y].add(new int[] {x, w * 2});
        }

        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dist = curr[0];
            int x = curr[1];

            if (x == n - 1) {
                return dist;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int[] neighbor : g[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (dist + w < d[y]) {
                    d[y] = dist + w;
                    pq.offer(new int[] {d[y], y});
                }
            }
        }
        return -1;
    }
}