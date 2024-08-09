class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int color = 10;
        int[][] count = new int[n][color + 1];
        for (int[] p : pick) {
            ++count[p[0]][p[1]];
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < color + 1; ++j) {
                if (count[i][j] > i) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
}