class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xors = 0;
        int n = nums.length;
        int[] prefix = new int[n];
        int max = (1 << maximumBit) - 1;
    
        for (int i = 0; i < n; ++i) {
            xors ^= nums[i];
            prefix[n - i - 1] = xors ^ max;
        }
        
        return prefix;
    }
}