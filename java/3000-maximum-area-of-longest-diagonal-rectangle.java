class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxAreaWithMaxDiagonal = 0;
        double maxDiagonal = 0;
        for (int[] d : dimensions) {
            maxDiagonal = Math.max(maxDiagonal, Math.sqrt(d[0] * d[0] + d[1] * d[1]));
        }
        for (int[] d : dimensions) {
            if (maxDiagonal == Math.sqrt(d[0] * d[0] + d[1] * d[1])) {
                maxAreaWithMaxDiagonal = Math.max(maxAreaWithMaxDiagonal, d[0] * d[1]);
            }
        }
        return maxAreaWithMaxDiagonal;
    }
}