class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0, n = nums.length;
        int prev = i;
        i = findToIndexOfStrictlyInc(nums, i, n);
        if (prev == i) {
            return false;
        }
        prev = i;
        i = findToIndexOfStrictlyDec(nums, i, n);
        if (prev == i) {
            return false;
        }
        prev = i;
        i = findToIndexOfStrictlyInc(nums, i, n);
        return prev != i && i == n - 1;
    }
    public int findToIndexOfStrictlyDec(int[] nums, int i, int n) {
        for (; i < n - 1; ++i) {
            if (nums[i] <= nums[i + 1]) {
                break;
            }
        }
        return i;
    }

    public int findToIndexOfStrictlyInc(int[] nums, int i, int n) {
        for (; i < n - 1; ++i) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
        }
        return i;
    }
}