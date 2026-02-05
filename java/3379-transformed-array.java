class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = nums[(i + n + (nums[i] % n)) % n];
        }
        return result;
    }
}