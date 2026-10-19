class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int i = 0, j = 0;
        while (!visited[i][j]) {
            visited[i][j] = true;
            if (grid[i][j] == 'L') {
                if (j == 0 || visited[i][j - 1]) {
                    break;
                }
                --j;
            }
            else if (grid[i][j] == 'R') {
                if (j == m - 1 || visited[i][j + 1]) {
                    break;
                }
                ++j;
            }
            else if (grid[i][j] == 'U') {
                if (i == 0 || visited[i - 1][j]) {
                    break;
                }
                --i;
            }
            else {
                if (i == n - 1 || visited[i + 1][j]) {
                    break;
                }
                ++i;
            }
        }
        return new int[] {i, j};
    }
}