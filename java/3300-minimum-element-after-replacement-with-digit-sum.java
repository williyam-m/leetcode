class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int n : nums) {
            ans = Math.min(ans, sumOfDigits(n));
        }
        return ans;
    }
    private int sumOfDigits(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}