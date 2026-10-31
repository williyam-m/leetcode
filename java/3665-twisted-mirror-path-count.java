class Solution {
    private int n;
    private int m;
    private final int mod = 1000000007;
    private int[][][] dp;
    public int uniquePaths(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        dp = new int[n][m][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        // 0 : right | 1 : down
        return (int) (((long) dfs(grid, 0, 1, 0) + dfs(grid, 1, 0, 1)) % mod);
    }
    private long dfs(int[][] grid, int i, int j, int dir) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i >= n || i < 0 || j >= m || j < 0) {
            return 0;
        }
        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }
        long way = 0;
        if (grid[i][j] == 1) {
            if (dir == 1) {
                way = dfs(grid, i, j + 1, 0);
            }
            else {
                way = dfs(grid, i + 1, j, 1);
            }
        }
        else {
            way = dfs(grid, i, j + 1, 0) + dfs(grid, i + 1, j, 1);
        }
        return dp[i][j][dir] = (int) (way % mod);
    }
}