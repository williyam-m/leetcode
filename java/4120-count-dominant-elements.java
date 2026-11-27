class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        int dominant = 0;
        if (n == 1) {
            return 1;
        }
        if (nums[0] >= nums[1]) {
            ++dominant;
        }
        if (nums[n - 1] >= nums[n - 2]) {
            ++dominant;
        }
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] >= (double) (nums[i - 1] + nums[i + 1]) / 2) {
                ++dominant;
            }
        }
        return dominant;
    }
}