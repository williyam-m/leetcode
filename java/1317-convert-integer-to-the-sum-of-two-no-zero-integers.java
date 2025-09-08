class Solution {
    public int[] getNoZeroIntegers(int n) {
        int l = 0, r = n;
        while (++l <= --r) {
            if (!containZero(l) && !containZero(r))
               return new int[] {l, r};
        }
        return new int[] {-1, -1};
    }
    private boolean containZero(int n) {
        while (n > 0) {
            if (n % 10 == 0)
               return true;
            n /= 10;
        }
        return false;
    }
}