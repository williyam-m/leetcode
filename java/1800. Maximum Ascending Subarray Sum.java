class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int ascendingOrderSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                ascendingOrderSum += nums[i];
                ans = Math.max(ans, ascendingOrderSum);
            }
            else {
                ascendingOrderSum = nums[i];
            }
        }
        return Math.max(ans, ascendingOrderSum);
    }
}