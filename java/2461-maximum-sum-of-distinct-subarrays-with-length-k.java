class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int distint = 0;
        long sum = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.merge(nums[i], 1, Integer::sum) == 1)
               ++distint;
            if (i >= k) {
                if (map.merge(nums[i - k], -1, Integer::sum) == 0)
                    --distint;
                sum -= nums[i - k];
            }
            if (distint == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}