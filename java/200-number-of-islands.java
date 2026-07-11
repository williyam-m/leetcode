class Solution {
    private int island = 0;
    private boolean[][] seen;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        seen = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    fill(grid, i, j, m, n);
                    ++islands;
                }
            }
        }
        return islands;
    }
    private void fill(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0' || seen[i][j]) {
            return;
        }
        seen[i][j] = true;
        fill(grid, i, j + 1, m, n);
        fill(grid, i + 1, j, m, n);
        fill(grid, i, j - 1, m, n);
        fill(grid, i - 1, j, m, n);
    }
}