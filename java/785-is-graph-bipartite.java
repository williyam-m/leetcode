class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (color[i] != 0) {
                continue;
            }
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int num : graph[curr]) {
                    if (color[num] == 0) {
                        color[num] = color[curr] == 1 ? -1 : 1;
                        q.add(num);
                    }
                    else if (color[num] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}