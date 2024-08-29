class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int island = 0;
        List<Integer>[] graph = new List[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (set.add(i)) {
                dfs(graph, i, set);
                ++island;
            }
        }
        return n - island;
    }

    private void dfs(List<Integer>[] graph, int u, Set<Integer> set) {
        for (int v : graph[u]) {
            if (set.add(v))
                dfs(graph, v, set);
        }
    }
}