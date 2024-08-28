class Solution {
    int n;
    int m;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid2.length;
        m = grid2[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid2[i][j] == 1)
                   ans += dfs(grid1, grid2, i, j);
            }
        }
        return ans;
    }
    private int dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i == n || j < 0 || j == m)
           return 1;
        
        if (grid2[i][j] == 0)
           return 1;
        if (grid1[i][j] == 0)
           return 0;
        
        grid2[i][j] = 0;

        return dfs(grid1, grid2, i + 1, j) & dfs(grid1, grid2, i - 1, j) & dfs(grid1, grid2, i, j + 1) & dfs(grid1, grid2, i, j - 1);

    }
}