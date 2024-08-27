class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair<Integer, Double>>[] graph = new List[n];
        Queue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(new Pair<>(v, succProb[i]));
            graph[v].add(new Pair<>(u, succProb[i]));
        }

        maxHeap.offer(new Pair<>(1.0, start_node));

        while (!maxHeap.isEmpty()) {
            double prob = maxHeap.peek().getKey();
            int u = maxHeap.poll().getValue();
            if (end_node == u)
               return prob;
            
            if (seen[u])
               continue;
            seen[u] = true;

            for (Pair<Integer, Double> g : graph[u]) {
                maxHeap.offer(new Pair<>(prob * g.getValue(), g.getKey()));
            }
        }
        return 0;
    }
}