class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        char[][] up = new char[m][n];
        char[][] down = new char[m][n];
        char[][] left = new char[m][n];
        char[][] right = new char[m][n];

        for (int[] g : guards)
            grid[g[0]][g[1]] = 'G';

        for (int[] w : walls)
            grid[w[0]][w[1]] = 'W';

        for (int i = 0; i < m; ++i) {
            char last = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'G' || grid[i][j] == 'W')
                    last = grid[i][j];
                else
                    left[i][j] = last;
            }
            last = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 'G' || grid[i][j] == 'W')
                    last = grid[i][j];
                else
                    right[i][j] = last;
            }
        }

        for (int j = 0; j < n; ++j) {
            char last = 0;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 'G' || grid[i][j] == 'W')
                    last = grid[i][j];
                else
                    up[i][j] = last;
            }
            last = 0;
            for (int i = m - 1; i >= 0; --i) {
                if (grid[i][j] == 'G' || grid[i][j] == 'W')
                    last = grid[i][j];
                else
                    down[i][j] = last;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && up[i][j] != 'G' && down[i][j] != 'G' && left[i][j] != 'G' && right[i][j] != 'G')   
                    ++ans;
            }
        }
        return ans;
    }
}