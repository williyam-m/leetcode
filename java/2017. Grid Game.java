class Solution {
    public long gridGame(int[][] grid) {
        long sumRow0 = 0;
        long sumRow1 = 0;
        long ans = Long.MAX_VALUE;
        int n = grid[0].length;
        for (int i = 0; i < n; ++i)
            sumRow0 += grid[0][i];
        
        for (int i = 0; i < n; ++i) {
            sumRow0 -= grid[0][i];
            ans = Math.min(ans, Math.max(sumRow0, sumRow1));
            sumRow1 += grid[1][i];
        }

        return ans;
    }
}