class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];

        for (int i = 0; i < n; ++i) {
            prefix[i] = nums[i];
            suffix[i] = nums[i];
        }

        for (int i = 1; i < n; ++i) {
            prefix[i] += prefix[i - 1];
            suffix[n - i - 1] += suffix[n - i];
        }
        

        for (int i = 0; i < n - 1; ++i) {
            if (prefix[i] >= suffix[i + 1])
               ++ans;
        }

        return ans;
    }
}