class Solution {
    public int makeConnected(int n, int[][] connections) {
        int totalEdges = connections.length;
        if (totalEdges < n - 1) {
            return -1;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int connected = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                continue;
            }
            ++connected;
            dfs(graph, visited, i);
        }
        return connected - 1;
    }
    private void bfs(List<List<Integer>> graph, boolean[] visited, int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int j = queue.poll();
            for (Integer next : graph.get(j)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    private void dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (Integer next : graph.get(i)) {
            bfs(graph, visited, next);
        }
    }
}