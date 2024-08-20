class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] mem = new int[n][n];
        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; --i)
            suffix[i] = suffix[i + 1] + piles[i];

        return stoneGameII(suffix, 0, 1, mem, n);
    }

    private int stoneGameII(int[] suffix, int i, int M, int[][] mem, int n) {
        if (i + 2 * M >= n)
            return suffix[i];
        if (mem[i][M] != 0)
            return mem[i][M];

        int res = suffix[i];
        for (int X = 1; X <= 2 * M; ++X)
            res = Math.min(res, stoneGameII(suffix, i + X, Math.max(X, M), mem, n));

        mem[i][M] = suffix[i] - res;

        return mem[i][M];
    }
}