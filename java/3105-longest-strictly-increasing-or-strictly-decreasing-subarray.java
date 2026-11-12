class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int currInc = 1;
        int currDec = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] < nums[i + 1]) {
                max = Math.max(max, ++currInc);
                currDec = 1;
            }
            else if (nums[i] > nums[i + 1]) {
                max = Math.max(max, ++currDec);
                currInc = 1;
            }
            else {
                currInc = 1;
                currDec = 1;
            }
        }
        return max;
    }
}