class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = findNextDescIndex(nums, 0);
        if (p == 0) { return false; }
        int q = findNextIncIndex(nums, p);
        if (p == q || q == n - 1) { return false; }
        return findNextDescIndex(nums, q) == n - 1;
    }
    private int findNextDescIndex(int[] nums, int i) {
        while (i < nums.length - 1) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
            ++i;
        }
        return i;
    }
    private int findNextIncIndex(int[] nums, int i) {
        while (i < nums.length - 1) {
            if (nums[i] <= nums[i + 1]) {
                break;
            }
            ++i;
        }
        return i;
    }
}