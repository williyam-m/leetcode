class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m ; ++j) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    queue.add(new int[] {i, j});
                }
                else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.peek()[0];
            int j = queue.poll()[1];

            for (int[] dir : directions) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row >= 0 && col >= 0 && row < n && col < m && ans[row][col] > ans[i][j] + 1) {
                    ans[row][col] = ans[i][j] + 1;
                    queue.add(new int[] {row, col});
                }
            }
        }
        return ans;
    }
}