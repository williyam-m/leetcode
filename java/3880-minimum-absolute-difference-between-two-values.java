class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int oneIndex = -1;
        int twoIndex = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                oneIndex = i;
            }
            else if (nums[i] == 2) {
                twoIndex = i;
            }
            if (oneIndex != -1 && twoIndex != -1) {
                diff = Math.min(diff, Math.abs(oneIndex - twoIndex));
            }
        }
        return diff == Integer.MAX_VALUE ? -1 : diff; 
    }
}