class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int[] maxArray = new int[n - k];
        maxArray[n - k - 1] = nums[n - 1];
        for (int i = n - k - 2; i >= 0; --i) {
            maxArray[i] = Math.max(nums[i + k], maxArray[i + 1]);
        }

        int maxValue = 0;
        for (int i = 0; i < n - k; ++i) {
            maxValue = Math.max(maxValue, nums[i] + maxArray[i]);
        }
        return maxValue;
    }
}