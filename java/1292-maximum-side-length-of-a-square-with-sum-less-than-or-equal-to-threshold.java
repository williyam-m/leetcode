class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        final int m = mat.length;
        final int n = mat[0].length;
        int[][] prefixRow = new int[m][n + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                prefixRow[i][j + 1] = prefixRow[i][j] + mat[i][j];
            }
        }

        for (int k = Math.min(m, n); k > 0; --k) {
            if (containsSquareWithMinSum(mat, prefixRow, k, threshold)) {
                return k;
            }
        }
        return 0;
    }
    private boolean containsSquareWithMinSum(int[][] mat, int[][] prefixRow, int k, int threshold) {
        for (int i = 0; i + k - 1 < mat.length; ++i) {
            for (int j = 0; j + k - 1 < mat[0].length; ++j) {
                if (isSquareWithMinSum(mat, prefixRow, i, j, k, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isSquareWithMinSum(int[][] mat, int[][] prefixRow, int i, int j, int k, int threshold) {
        int sum = 0;
        for (int d = 0; d < k; ++d) {
            sum += getSum(prefixRow[i + d], j, j + k - 1);
        }
        return sum <= threshold;
    }
    private int getSum(int[] prefixSum, int l, int r) {
        return prefixSum[r + 1] - prefixSum[l];
    }
}