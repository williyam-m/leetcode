class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        int kMax = 2_000_000_000;
        List<Pair<Integer, Integer>>[] graph = new List[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[2] == -1)
                continue;
            graph[edge[0]].add(new Pair<>(edge[1], edge[2]));
            graph[edge[1]].add(new Pair<>(edge[0], edge[2]));
        }

        int shortestDistance = dijkstra(graph, source, destination);
        if (shortestDistance < target)
            return new int[0][];

        if (shortestDistance == target) {
            for (int[] edge : edges) {
                if (edge[2] == -1)
                    edge[2] = kMax;
            }
            return edges;
        }
        for (int i = 0; i < edges.length; ++i) {
            if (edges[i][2] != -1)
                continue;
            edges[i][2] = 1;
            graph[edges[i][0]].add(new Pair<>(edges[i][1], 1));
            graph[edges[i][1]].add(new Pair<>(edges[i][0], 1));
            shortestDistance = dijkstra(graph, source, destination);

            if (shortestDistance <= target) {
                edges[i][2] += target - shortestDistance;
                for (int j = i + 1; j < edges.length; ++j) {
                    if (edges[j][2] == -1)
                        edges[j][2] = kMax;
                }
                return edges;
            }
        }

        return new int[0][];
    }

    private int dijkstra(List<Pair<Integer, Integer>>[] graph, int source, int destination) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        dist[source] = 0;
        minHeap.offer(new Pair<>(dist[source], source));

        while (!minHeap.isEmpty()) {
            int d = minHeap.peek().getKey();
            int u = minHeap.poll().getValue();
            if (d > dist[u])
                continue;
            for (Pair<Integer, Integer> pair : graph[u]) {
                int v = pair.getKey();
                int w = pair.getValue();
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    minHeap.offer(new Pair<>(dist[v], v));
                }
            }
        }
        return dist[destination];
    }
}