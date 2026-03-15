class Solution {
    public int countCommas(int n) {
        if (n <= 999) {
            return 0;
        }
        int ans = 0;
        int i = (String.valueOf(n).length() - 1) / 3;
        n -= 999;
        while (i > 0) {
            ans += i-- * n;
            n -= 999;
        }
        return ans;
    }
}