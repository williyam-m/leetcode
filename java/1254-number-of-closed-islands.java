class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < m - 1; ++j) {
                if (grid[i][j] == 0) {
                    if (fillAndUpdate(i, j, n, m, grid)) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
    private boolean fillAndUpdate (int i, int j, int n, int m, int[][] grid) {
        if (i == n || i < 0 || j == m || j < 0) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean down = fillAndUpdate(i + 1, j, n, m, grid);
        boolean up = fillAndUpdate(i - 1, j, n, m, grid);
        boolean right = fillAndUpdate(i, j + 1, n, m, grid);
        boolean left = fillAndUpdate(i, j - 1, n, m, grid);
        return down && up && right && left;
    } 
}