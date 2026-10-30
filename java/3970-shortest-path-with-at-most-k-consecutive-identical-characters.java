class Path {
    int node;
    int weight;
    int k;
    Path (int node, int weight, int k) {
        this.node = node;
        this.weight = weight;
        this.k = k;
    }
}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
            for (int j = 0; j <= k; ++j) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        Queue<Path> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Path(0, 0, 1));
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Path path = pq.poll();
            if (path.node == n - 1) {
                return path.weight;
            }
            if (dist[path.node][path.k] < path.weight) {
                continue;
            }
            char label = labels.charAt(path.node);
            for (int[] next : graph.get(path.node)) {
                int nextK = 1;
                if (label == labels.charAt(next[0])) {
                    if (path.k >= k) {
                        continue;
                    }
                    nextK = path.k + 1;
                }
                if (dist[next[0]][nextK] > path.weight + next[1]) {
                    dist[next[0]][nextK] = path.weight + next[1];
                    pq.add(new Path(next[0], path.weight + next[1], nextK));
                }
            }
        }
        return -1;
    }
}