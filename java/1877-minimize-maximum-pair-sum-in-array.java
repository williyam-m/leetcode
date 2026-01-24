class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int maxPairSum = 0;
        while (l < r) {
            maxPairSum = Math.max(maxPairSum, nums[l++] + nums[r--]);
        }
        return maxPairSum;
    }
}