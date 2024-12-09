class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int len = queries.length;
        boolean[] ans =  new boolean[len];
        int[] prefixSum =  new int[n];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1];
            if (nums[i - 1] % 2 == nums[i] % 2)
                ++prefixSum[i];
        }
        for (int j = 0; j < len; ++j) {
            int from = queries[j][0], to = queries[j][1];
            ans[j] = prefixSum[to] - prefixSum[from] == 0 ? true : false;
        }
        return ans;
    }
}