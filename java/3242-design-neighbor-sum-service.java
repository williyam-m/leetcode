class neighborSum {
    Map<Integer, int[]> valToIndex = new HashMap<>();
    int[][] adjacentPosition = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    int[][] diagonalPosition = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
    int[][] grid;
    int n;

    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                valToIndex.put(grid[i][j], new int[] { i, j });
    }

    public int adjacentSum(int value) {
        return findSum(value, adjacentPosition);
    }

    public int diagonalSum(int value) {
        return findSum(value, diagonalPosition);
    }

    public int findSum(int value, int[][] position) {
        int ans = 0;
        int[] index = valToIndex.get(value);

        for (int[] p : position) {
            int x = p[0] + index[0];
            int y = p[1] + index[1];
            if ((x >= 0 && x < n) && (y >= 0 && y < n))
                ans += grid[x][y];
        }

        return ans;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */