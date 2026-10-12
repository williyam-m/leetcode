class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1, -1};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] != nums[j] && nums[i] + nums[j] == target && nums[i] * nums[j] > max) {
                    max = nums[i] * nums[j];
                    ans = nums[i] > nums[j] ? new int[] {i, j} : new int[] {j, i};
                }
            }
        }
        return ans;
    }
}