class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length - 1; ++i) {
            max = Math.max(max, nums[i]);
            if (max-- <= 0) {
                return false;
            }
        }
        return true;
    }
}