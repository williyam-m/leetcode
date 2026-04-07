class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (max1 < n) {
                max2 = max1;
                max1 = n;
            }
            else if (max2 < n) {
                max2 = n;
            }
            min = Math.min(min, n);
        }
        return max1 + max2 - min;
        /*
        Arrays.sort(nums);
        return nums[nums.length - 1] + nums[nums.length - 2] - nums[0];
        */
    }
}