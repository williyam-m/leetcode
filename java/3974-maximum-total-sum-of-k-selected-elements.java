class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long total = 0;
        int i = nums.length - 1;
        while (k > 0 && i >= 0) {
            if (nums[i] > 0 || (nums[i] * mul) > 0) {
                total += Math.max(nums[i], ((long) nums[i] * mul));
                --mul;
                --k;
            }
            --i;
        }
        return total;
    }
}