class Solution {
    public int numSubseq(int[] nums, int target) {
        final int mod = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int valid = 0;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                valid = (valid + power[r - l]) % mod;
                ++l;
            }
            else {
                --r;
            }
        }
        return valid;
    }
}