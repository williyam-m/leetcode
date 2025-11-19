class Solution {
    public int findFinalValue(int[] nums, int original) {
        int ans = original;
        Arrays.sort(nums);
        for (int n : nums) {
            if (n == ans) {
                ans *= 2;
            }
        }
        return ans;
    }
}