class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        Arrays.sort(nums);
        long sum = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            sum += (long) nums[r] * (long) nums[r--];
            if (l <= r) {
                sum -= (long) nums[l] * (long) nums[l++];
            }
        }
        return sum;
    }
}