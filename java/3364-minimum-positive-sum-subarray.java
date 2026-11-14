class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            prefix[i] = prefix[i - 1] + nums.get(i - 1);
        }
        for (int i = 0; i < n - l + 1; ++i) {
            for (int j = l; j <= r && i + j < n + 1; ++j) {
                int val = prefix[i + j] - prefix[i];
                if (val > 0) {
                    min = Math.min(min, val);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}