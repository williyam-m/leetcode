class Solution {
    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i += 2) {
            min = Math.min(min, mergeInt(nums[i], nums[i + 1]));
        }
        return min;
    }
    private int mergeInt(int n1, int n2) {
        int temp = n2;
        while (temp > 0) {
            n1 *= 10;
            temp /= 10;
        }
        return n1 + n2;
    }
}