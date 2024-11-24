class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long absSum = 0;
        int absMin = Integer.MAX_VALUE;
        int oddNeg = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                absSum += Math.abs(num);
                absMin = Math.min(absMin, Math.abs(num));
                if (num < 0)
                   oddNeg ^= 1;
            }
        }
        return absSum - (oddNeg * absMin * 2);
    }
}