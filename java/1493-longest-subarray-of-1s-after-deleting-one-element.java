class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0, curr = 0, ans = 0;
        boolean containsZero = false;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                prev = curr;
                curr = 0;
                containsZero = true;
            }
            else {
                ans = Math.max(ans, prev + ++curr);
            }
        }
        if (!containsZero) {
            --ans;
        }
        return ans;
    }
}