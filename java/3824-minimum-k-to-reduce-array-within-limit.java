class Solution {
    public int minimumK(int[] nums) {
        int l = 1;
        int r = 0;
        for (int n : nums) {
            r = Math.max(r, n);
        }
        r = Math.max(r, nums.length);
        int ans = r;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nonPositive(nums, m) <= (long) m * m) {
                r = m;
                ans = m;
            }
            else {
                l = m + 1;
            }
        }
        return ans;
    }
    private long nonPositive(int[] nums, int k) {
        long times = 0;
        for (int n : nums) {
            times += (n + (k - 1)) / k;
        }
        return times;
    }
}