class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                if (check(grid, i, j))
                    ++ans;
            }
        }
        return ans;
    }

    private boolean check(int[][] grid, int i, int j) {
        int[] count = new int[10];
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int r = 0;
        int c = 0;
        for (int k = i; k < i + 3; ++k) {
            for (int l = j; l < j + 3; ++l) {
                if (grid[k][l] > 9 || grid[k][l] < 1 || ++count[grid[k][l]] > 1) {
                    return false;
                }
                rowSum[r] += grid[k][l];
                colSum[c++] += grid[k][l];
            }
            ++r;
            c = 0;
        }
        if (rowSum[0] != rowSum[1] && rowSum[1] != rowSum[2])
            return false;
        if (colSum[0] != colSum[1] && colSum[1] != colSum[2])
            return false;
        // diagonal
        if (grid[i][j] + grid[i + 2][j + 2] != grid[i][j + 2] + grid[i + 2][j])
            return false;

        return true;
    }
}