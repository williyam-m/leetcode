class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int[] max = new int[n + 1];
        int[] ans = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n; ++i) {
            max[i + 1] = Math.max(max[i], items[i][1]);
        }

        for (int i = 0; i < queries.length; ++i) {
            ans[i] = max[firstGreater(queries[i], items)];
        }

        return ans;
    }
    private int firstGreater(int q, int[][] items) {
        int l = 0;
        int r = items.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (items[m][0] > q)
               r = m;
            else
               l = m + 1;
        }
        return l;
    }
}