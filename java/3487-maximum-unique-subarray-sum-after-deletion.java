class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] <= 0) {
            return nums[n - 1];
        }
        int ans = 0;

        if (nums[0] > 0) {
            ans = nums[0];
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0 && nums[i - 1] != nums[i]) {
                ans += nums[i];
            }
        }
        return ans;
    }
}