class Solution {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) {
                    if (isValidIsland(i, j, n, m, grid, k)) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValidIsland(int i, int j, int n, int m, int[][] grid, int k) {
        long sum = grid[i][j];
        grid[i][j] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int a = queue.peek()[0];
            int b = queue.poll()[1];
            for (int[] dir : dirs) {
                int x = a + dir[0];
                int y = b + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 0) {
                    queue.add(new int[] {x, y});
                    sum += grid[x][y];
                    grid[x][y] = 0;
                }
            }
        }
        return sum % k == 0;
    }
}