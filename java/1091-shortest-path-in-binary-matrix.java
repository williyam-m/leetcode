class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        boolean[][] seen = new boolean[n][n];
        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            };
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        seen[0][0] = true;
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int val = q.poll()[2];
            if (i == n - 1 && j == n - 1) {
                return val;
            }
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && !seen[x][y]) {
                    q.add(new int[] {x, y, val + 1});
                    seen[x][y] = true;
                }
            }
        }
        return -1;
    }
}