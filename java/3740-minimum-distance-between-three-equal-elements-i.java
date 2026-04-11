class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] == nums[j] && nums[i] == nums[k]) {
                        ans = Math.min(ans, (j - i) + (k - j) + (k - i));
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? - 1 : ans;
    }
}