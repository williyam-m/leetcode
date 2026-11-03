class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        return (max * nums.length) - sum;
    }
}