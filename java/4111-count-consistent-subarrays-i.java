class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int min = nums[i];
            int and = nums[i];
            for (int j = i + 1; j < n; ++j) {
                min = Math.min(min, nums[j]);
                and &= nums[j];
                if (min == and) {
                    ++ans;
                }
            }
        }
        return ans + n;
    }
}