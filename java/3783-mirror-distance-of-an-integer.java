class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    private int reverse (int n) {
        int ans = 0;
        while (n > 0) {
            ans *= 10;
            ans += (n % 10);
            n /= 10;
        }
        return ans;
    }
}