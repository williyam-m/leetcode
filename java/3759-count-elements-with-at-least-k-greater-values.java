class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return n;
        }
        Arrays.sort(nums);
        int i = n - k;
        while (i > 0 && nums[i] == nums[i - 1]) {
            --i;
        }
        return i;
    }
}