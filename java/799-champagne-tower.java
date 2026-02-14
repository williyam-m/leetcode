class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] champagne = new double[query_row + 1][100];
        champagne[0][0] = (double) poured;
        for (int r = 0; r < query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double pass = (champagne[r][c] - 1.0) / 2.0;
                if (pass > 0) {
                    champagne[r + 1][c] += pass;
                    champagne[r + 1][c + 1] += pass;
                }
            }
        }
        return Math.min(1, champagne[query_row][query_glass]);
    }
}