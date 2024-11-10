class Solution {
    int kMax = 32;
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] count = new int[kMax];
        int n = nums.length;
        int ans = n + 1;
        int ors = 0;

        for (int l = 0, r = 0; r < n; ++r) {
            ors = orNum(ors, nums[r], count);
            while (ors >= k && l <= r) {
                ans = Math.min(ans, r - l + 1);
                ors = undoOrNum(ors, nums[l++], count);
            }
        }
        return ans == n + 1  ? -1 : ans;
    }
    private int orNum(int ors, int num, int[] count) {
        for (int i = 0; i < kMax; ++i) {
            if ((num >> i & 1) == 1 && ++count[i] == 1)
               ors += 1 << i;
        }
        return ors;
    }

    private int undoOrNum(int ors, int num, int[] count) {
        for (int i = 0; i < kMax; ++i) {
            if ((num >> i & 1) == 1 && --count[i] == 0)
               ors -= 1 << i;
        }
        return ors;
    }
}