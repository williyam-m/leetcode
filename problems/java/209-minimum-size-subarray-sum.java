class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int r = 0, l = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        while (r < n) {
            while (sum < target && r < n) {
                sum += nums[r++];
            }
            while (sum >= target) {
                ans = Math.min(ans, r - l);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}