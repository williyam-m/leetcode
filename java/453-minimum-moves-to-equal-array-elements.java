class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}