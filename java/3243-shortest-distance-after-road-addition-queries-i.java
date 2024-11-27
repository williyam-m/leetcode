class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] dist = new int[n];
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i) {
            dist[i] = i;
            graph[i] = new ArrayList<>();
            if (i != n - 1)
               graph[i].add(i + 1);
        }
        

        for (int i = 0; i < queries.length; ++i) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(v);
            if (dist[u] + 1 < dist[v]) {
                dist[v] = dist[u] + 1;
                bfs(graph, v, dist);
            }
            ans[i] = dist[n - 1];
        }
        return ans;
    }
    private void bfs(List<Integer>[] graph, int start, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
    }
}