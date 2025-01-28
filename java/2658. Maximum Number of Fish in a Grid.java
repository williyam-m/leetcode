class Solution {
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] > 0)
                    ans = Math.max(ans, dfs (i, j, grid));
            }
        }
        return ans;
    }
    private int dfs (int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
           return 0;
        if (grid[i][j] == 0)
           return 0;
        int caughtFish = grid[i][j];
        grid[i][j] = 0;
        return caughtFish + dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid);
    }
}