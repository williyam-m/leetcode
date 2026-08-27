class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // we can also use visited array to track
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        q.add(new int[] {0, 0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int val = q.poll()[2];
            if (i == n - 1 && j == m - 1) {
                return val;
            }
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int newEffort = Math.max(val, Math.abs(heights[x][y] - heights[i][j]));
                    if (newEffort < dist[x][y]) {
                        dist[x][y] = newEffort;
                        q.add(new int[] {x, y, newEffort});
                    }
                }
            }
        }
        return -1;
    }
}