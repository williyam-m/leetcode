class Solution {
    private int m;
    private int n;
    private int freshOranges = 0;
    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
                else if (grid[i][j] == 1) {
                    ++freshOranges;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        else if (queue.isEmpty()) {
            return -1;
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            for (int len = queue.size(); len > 0; --len) {
                int i = queue.peek()[0];
                int j = queue.pop()[1];
                checkAndUpdate(i, j + 1, queue, grid);
                checkAndUpdate(i + 1, j, queue, grid);
                checkAndUpdate(i - 1, j, queue, grid);
                checkAndUpdate(i, j - 1, queue, grid);
            }
            ++minutes;
        }

        if (freshOranges != 0) {
            return -1;
        }
        return minutes - 1;
    }
    private void checkAndUpdate(int i, int j, Deque<int[]> queue, int[][] grid) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1) {
            grid[i][j] = 2;
            --freshOranges;
            queue.add(new int[] {i, j});
        }
    }
}