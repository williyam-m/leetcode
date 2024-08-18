class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; ++i) {
            int next2 = ans[i2] * 2;
            int next3 = ans[i3] * 3;
            int next5 = ans[i5] * 5; 
            int next = Math.min(next2, Math.min(next3, next5));

            if (next == next2)
               ++i2;
            if (next == next3)
               ++i3;
            if (next == next5)
               ++i5;
            ans[i] = next;
        }
        return ans[n - 1];
    }
}