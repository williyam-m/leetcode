class Solution {
    public int findKthNumber(int n, int k) {
        long ele = 1;
        for (int i = 1; i < k;) {
            long gap = getGap(ele, ele + 1, n);
            if (i + gap <= k) {
                i += gap;
                ++ele;
            } else {
                ++i;
                ele *= 10;
            }
        }
        return (int) ele;
    }

    private long getGap(long a, long b, long n) {
        long gap = 0;

        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}