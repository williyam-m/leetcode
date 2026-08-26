class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adjList = new List[n];
        int[] outDegree = new int[n];

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            outDegree[i] = graph[i].length;
            for (int adj : graph[i]) {
                adjList[adj].add(i);
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (outDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            for (int adj : adjList[q.poll()]) {
                if (--outDegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (outDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}