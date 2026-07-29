class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    fill(i, j, grid);
                    ++islands;
                }
            }
        }
        return islands;
    }
    private void fill(int i, int j, char[][] grid) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        fill(i + 1, j, grid);
        fill(i - 1, j, grid);
        fill(i, j + 1, grid);
        fill(i, j - 1, grid);
    }
}