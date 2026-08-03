class Solution {
    public int largestInteger(int n, int s) {
        if ((9 * n) < s) {
            return -1;
        }
        int ans = 0;
        while (n-- > 0) {
            int curr = s >= 9 ? 9 : s;
            ans *= 10;
            ans += curr;
            s -= curr;
        }
        return ans;
    }
}