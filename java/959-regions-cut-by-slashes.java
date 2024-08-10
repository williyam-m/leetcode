class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n * 3][n * 3];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                }
                else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n * 3; ++i) {
            for (int j = 0; j < n * 3; ++j) {
                if (g[i][j] == 0) {
                    dfs(g, i, j, n * 3);
                    ++ans;
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] g, int i, int j, int n) {
        if (i < 0 || i == n || j < 0 || j == n)
            return ;
        if (g[i][j] == 1)
            return ;
        g[i][j] = 1;
        dfs(g, i + 1, j, n);
        dfs(g, i - 1, j, n);
        dfs(g, i, j + 1, n);
        dfs(g, i, j - 1, n);
    }
}