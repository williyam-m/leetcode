class Solution {
    private int diameter;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = getDiameter(edges1);
        int diameter2 = getDiameter(edges2);
        int combine = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;
        return Math.max(Math.max(diameter1, diameter2), combine);
    }
    private int getDiameter (int[][] edges) {
        diameter = 0;
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        maxDepth(graph, 0, -1);
        return diameter;
    }
    private int maxDepth(List<Integer>[] graph, int u, int prev) {
        int depth1 = 0;
        int depth2 = 0;
        for (int v : graph[u]) {
            if (v == prev)
               continue;
            int depth = maxDepth(graph, v, u);
            
            if (depth > depth1) {
                depth2 = depth1;
                depth1 = depth;
            }
            else if (depth > depth2) {
                depth2 = depth;
            }
        }
        diameter = Math.max(diameter, depth1 + depth2);
        return 1 + depth1;
    }
}