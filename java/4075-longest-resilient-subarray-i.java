class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= i; --j) {
                boolean flag = true;
                int sum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                for (int l = i; l <= j; ++l) {
                    if ((sum - nums[l]) % k != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }
        return max;
    }
}