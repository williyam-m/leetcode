class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    island(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void island(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if (grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        island(grid, i + 1, j);
        island(grid, i, j + 1);
        island(grid, i - 1, j);
        island(grid, i, j - 1);
    }
}