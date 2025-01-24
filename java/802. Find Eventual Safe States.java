class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] state = new int[n];

        for (int i = 0; i < n; ++i) {
            if (dfs(graph, i, state))
               ans.add(i);
        }

        return ans;
    }

    public boolean dfs (int[][] graph, int u, int[] state) {
        if (state[u] > 0)
           return state[u] == 2;
        
        state[u] = 1;
        for (int v : graph[u]) {
            if (!dfs(graph, v, state))
               return false;
        }

        state[u] = 2;
        return true;
    }
}