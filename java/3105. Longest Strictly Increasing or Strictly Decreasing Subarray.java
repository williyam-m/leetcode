class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int dec = 1;
        int decMax = 1;
        int inc = 1;
        int incMax = 1;

        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] < nums[i + 1]) {
                incMax = Math.max(incMax, ++inc);
            }
            else {
                inc = 1;
            }

            if (nums[i] > nums[i + 1]) {
                decMax = Math.max(decMax, ++dec);
            }
            else {
                dec = 1;
            }
        }

        return Math.max(incMax, decMax);
    }
}