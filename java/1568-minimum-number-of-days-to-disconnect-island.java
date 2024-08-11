class Solution {
    private int m;
    private int n;

    public int minDays(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        if (disconnected(grid))
            return 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (disconnected(grid))
                        return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private boolean disconnected(int[][] grid) {
        int island = 0;
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 || seen[i][j])
                    continue;
                if (++island > 1)
                    return true;
                dfs(grid, seen, i, j);
            }
        }
        return island != 1;
    }

    private void dfs(int[][] grid, boolean[][] seen, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n)
            return ;
        if (grid[i][j] == 0 || seen[i][j])
            return ;
        
        seen[i][j] = true;
        dfs(grid, seen, i + 1, j);
        dfs(grid, seen, i - 1, j);
        dfs(grid, seen, i, j + 1);
        dfs(grid, seen, i, j - 1);
    }
}