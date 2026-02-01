class Solution {
    public int minimumCost(int[] nums) {
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            int n = nums[i];
            if (minOne > n) {
                minTwo = minOne;
                minOne = n;
            }
            else if (minTwo > n) {
                minTwo = n;
            }
        }
        return nums[0] + minOne + minTwo;
    }
}