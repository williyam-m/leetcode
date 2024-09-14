class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = 0;
        int ans = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (maxNum <= nums[i]) {
                count = 1;
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    ++count;
                    ++i;
                }
                if (maxNum == nums[i])
                   ans = Math.max(ans, count);
                else
                   ans = count;
                maxNum = nums[i];  
            }
        }
        return ans;
    }
}