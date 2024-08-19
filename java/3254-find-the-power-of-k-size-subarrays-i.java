class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; ++i) {
            if (isValid(nums, i, i + k - 1))
                ans[i] = nums[i + k - 1];
            else
                ans[i] = -1;
        }
        return ans;
    }

    private boolean isValid(int[] nums, int start, int end) {
        for (int i = start; i < end; ++i) {
            if (nums[i] != nums[i + 1] - 1)
                return false;
        }
        return true;
    }
}