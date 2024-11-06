class Solution {
    public boolean canSortArray(int[] nums) {
        int prevSetBits = 0;
        int prevMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;

        for (int num : nums) {
            int setBits = Integer.bitCount(num);
            if (prevSetBits != setBits) {
                if (prevMax > currMin)
                   return false;
                prevSetBits = setBits;
                prevMax = currMax;
                currMin = num;
                currMax = num;
            }
            else {
                currMin = Math.min(currMin, num);
                currMax = Math.max(currMax, num);
            }
        }
        return prevMax <= currMin;
    }
}