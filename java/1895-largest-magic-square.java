class Solution {
    public int largestMagicSquare(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] prefixRow = new int[m][n + 1];
        int[][] prefixCol = new int[n][m + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                prefixRow[i][j + 1] = prefixRow[i][j] + grid[i][j];
                prefixCol[j][i + 1] = prefixCol[j][i] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k >= 2; --k) {
            if (containsMagicSquare(grid, prefixRow, prefixCol, k)) 
                return k;
        }
        return 1;
    }
    
    private boolean containsMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int k) {
        for (int i = 0; i + k - 1 < grid.length; ++i) {
            for (int j = 0; j + k - 1 < grid[0].length; ++j) {
                if (isMagicSquare(grid, prefixRow, prefixCol, i, j, k))
                   return true;
            }
        }
        return false;
    }

    private boolean isMagicSquare(int[][] grid, int[][] prefixRow, int[][] prefixCol, int i, int j, int k) {
        int diagonal = 0;
        int antiDiagonal = 0;

        for (int d = 0; d < k; ++d) {
            diagonal += grid[i + d][j + d];
            antiDiagonal += grid[i + d][j + k - 1 - d];
        }
        if (diagonal != antiDiagonal)
           return false;

        for (int d = 0; d < k; ++d) {
            if (getSum(prefixRow, i + d, j, j + k - 1) != diagonal)
               return false;
            if (getSum(prefixCol, j + d, i, i + k - 1) != diagonal)
               return false;
        }
        return true;
    }

    private int getSum(int[][] prefixSum, int i, int l, int r) {
        return prefixSum[i][r + 1] - prefixSum[i][l];
    }
}