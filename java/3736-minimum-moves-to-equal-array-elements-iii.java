class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        return (max * nums.length) - sum;
    }
}