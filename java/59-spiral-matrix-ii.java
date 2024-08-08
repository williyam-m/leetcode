class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int value = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; ++i) {
                ans[top][i] = value++;
            }
            ++top;
            for (int i = top; i <= bottom; ++i) {
                ans[i][right] = value++;
            }
            --right;
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    ans[bottom][i] = value++;
                }
            }
            --bottom;
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans[i][left] = value++;
                }
            }
            ++left;
        }
        return ans;
    }
}