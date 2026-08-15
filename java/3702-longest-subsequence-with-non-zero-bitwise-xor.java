class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;
        for (int num : nums) {
            totalXor ^= num;
            if (num > 0) {
                allZero = false;
            }
        }
        if (totalXor != 0) {
            return n;
        }
        return allZero ? 0 : n - 1;
    }
}