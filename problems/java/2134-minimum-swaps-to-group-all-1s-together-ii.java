class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int num : nums)
            k += num == 1 ? 1 : 0;
        int maxOnes = 0;
        int ones = 0;
        for (int i = 0; i < 2 * n; ++i) {
            if (nums[i % n] == 1)
                ++ones;
            if (i >= k && nums[(i - k) % n] == 1)
                --ones;
            maxOnes = Math.max(maxOnes, ones);
        }
        return k - maxOnes;
    }
}