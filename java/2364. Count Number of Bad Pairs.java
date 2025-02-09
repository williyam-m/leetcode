class Solution {
    public long countBadPairs(int[] nums) {
        long ans = 0;
        Map<Integer, Long> count = new HashMap<>(); 

        for (int i = 0; i < nums.length; ++i) {
            ans += i - count.getOrDefault(nums[i] - i, 0L);
            count.merge(nums[i] - i, 1L, Long::sum);
        }

        return ans;
    }
}