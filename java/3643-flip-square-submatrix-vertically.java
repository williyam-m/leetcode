class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = x; i < x + (k / 2); ++i) {
            for (int j = y; j < (y + k); ++j) {
                swap(grid, i, j, x + k - 1 - (i - x), j);
            }
        }
        return grid;
    }
    private void swap(int[][] grid, int a, int b, int c, int d) {
        int temp = grid[a][b];
        grid[a][b] = grid[c][d];
        grid[c][d] = temp;
    }
}