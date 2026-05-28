class Solution {
    public int minimumSwaps(int[] nums) {
        int ones = 0;
        for (int n : nums) {
            if (n == 0) {
                ++ones;
            }
        }
        for (int i = nums.length - ones; i < nums.length; ++i) {
            if (nums[i] == 0) {
                --ones;
            }
        }
        return ones;
    }
}