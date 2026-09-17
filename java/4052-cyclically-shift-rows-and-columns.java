class Solution {
    int[][] grid;
    int n;
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        this.grid = grid;
        this.n = n;
        for (int i = 0; i < n; ++i) {
            rotateRowAntiClock(i, rowShift[i]);
        }
        for (int i = 0; i < n; ++i) {
            rotateColAntiClock(i, colShift[i]);
        }
        return grid;
    }
    public void rotateRowAntiClock(int i, int k) {
        rotateRow(i, 0, k - 1);
        rotateRow(i, k, n - 1);
        rotateRow(i, 0, n - 1);
    }
    public void rotateRow(int i, int l, int r) {
        while (l < r) {
            int temp = grid[i][l];
            grid[i][l++] = grid[i][r];
            grid[i][r--] = temp;
        }
    }
    public void rotateColAntiClock(int i, int k) {
        rotateCol(i, 0, k - 1);
        rotateCol(i, k, n - 1);
        rotateCol(i, 0, n - 1);
    }
    public void rotateCol(int i, int l, int r) {
        while (l < r) {
            int temp = grid[l][i];
            grid[l++][i] = grid[r][i];
            grid[r--][i] = temp;
        }
    }
}