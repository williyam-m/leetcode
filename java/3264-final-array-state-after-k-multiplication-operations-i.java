class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int index = 0;
        while (k-- > 0) {
            int min = nums[0];
            for (int i = 1; i < n; ++i) {
                if (nums[i] < min) {
                    index = i;
                    min = nums[i];
                }
            }
            nums[index] = nums[index] * multiplier;
            index = 0;
        }
        return nums;
    }
}