class Solution {
    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] dp = new long[n];

        for (int[] row : points) {
            long[] leftToRight = new long[n];
            long max = 0;
            for (int j = 0; j < n; ++j) {
                max = Math.max(max - 1, dp[j]);
                leftToRight[j] = max;
            }

            long[] rightToLeft = new long[n];
            max = 0;
            for (int j = n - 1; j >= 0; --j) {
                max = Math.max(max - 1, dp[j]);
                rightToLeft[j] = max;
            }

            for (int j = 0; j < n; ++j) {
                dp[j] = Math.max(leftToRight[j], rightToLeft[j]) + row[j];
            }
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}