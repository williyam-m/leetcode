class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int l = -1, r;
        for (r = 0; r < nums.length; ++r) {
            if (nums[r] == 0) {
                max = Math.max(max, r - l - 1);
                l = r;
            }
        }
        return Math.max(max, r - l - 1);
    }
}