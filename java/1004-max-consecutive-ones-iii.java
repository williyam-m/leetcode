class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r;
        int max = 0;
        for (r = 0; r < nums.length; ++r) {
            if (nums[r] == 0) {
                --k;
                while (k < 0) {
                    if (nums[l++] == 0) {
                        ++k;
                    }
                }
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}