class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    private int currEnclaves = 0;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int enclaves = 0;

        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    findNumEnclaves(i, j, grid);
                    enclaves += currEnclaves != -1 ? currEnclaves : 0;
                }
                currEnclaves = 0;
            }
        }
        return enclaves;
    }
    private void findNumEnclaves(int i, int j, int[][] grid) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j] || grid[i][j] == 0) {
            return;
        } 
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
            currEnclaves = -1;
        }
        visited[i][j] = true;
        if (currEnclaves != -1) {
            ++currEnclaves;
        }
        findNumEnclaves(i + 1, j, grid);
        findNumEnclaves(i - 1, j, grid);
        findNumEnclaves(i, j + 1, grid);
        findNumEnclaves(i, j - 1, grid);
    }
}