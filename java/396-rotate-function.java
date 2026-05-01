class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            f += nums[i] * i;
            sum += nums[i];
        }
        int ans = f;
        for (int i = n - 1; i > 0; --i) {
            f += (sum - n * nums[i]);
            ans = Math.max(ans, f);
        }
       return ans;
    }
}