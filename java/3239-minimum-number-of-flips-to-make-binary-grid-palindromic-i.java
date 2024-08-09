class Solution {
    public int minFlips(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        return Math.min(flipRow(grid, n), flipCol(grid, m, n));
    }

    private int flipRow(int[][] grid, int n) {
        int flip = 0;
        for (int[] row : grid) {
            flip += requireFlipRow(row, 0, n - 1);
        }
        return flip;
    }

    private int flipCol(int[][] grid, int m, int n) {
        int flip = 0;
        for (int j = 0; j < n; ++j) {
            flip += requireFlipCol(grid, j, 0, m - 1);
        }
        return flip;
    }

    private int requireFlipCol(int[][] grid, int j, int l, int r) {
        int count = 0;
        while (l < r) {
            if (grid[l++][j] != grid[r--][j])
                ++count;
        }
        return count;
    }

    private int requireFlipRow(int[] row, int l, int r) {
        int count = 0;
        while (l < r) {
            if (row[l++] != row[r--])
                ++count;
        }
        return count;
    }
}