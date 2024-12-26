class Solution {
    private int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ans;
    }
    private void dfs (int[] nums, int target, int i, int sum) {
        if (nums.length == i) {
            if (sum == target)
               ++ans;
            return ;
        }
        dfs(nums, target, i + 1, sum + nums[i]);
        dfs(nums, target, i + 1, sum - nums[i]);
    }
}