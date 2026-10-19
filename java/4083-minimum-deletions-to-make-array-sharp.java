class Solution {
    public int minDeletions(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] != nums[i + 1]) {
                ++ans;
            }
        }
        return nums.length - ans - 1;
    }
}