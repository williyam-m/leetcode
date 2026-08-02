class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                ans = Math.max(ans, ((long) nums[i] * (long) nums[j]) / (long) Math.pow(gcd(nums[i], nums[j]), 2));
            }
        }
        return ans;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}