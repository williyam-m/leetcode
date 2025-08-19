class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long curr = 0;
        long currTotal = 0;
        for (int n : nums) {
            if (n != 0) {
                total += currTotal;
                curr = 0;
                currTotal = 0;
            }
            else {
                ++curr;
                currTotal += curr;
            }
        }

        return total + currTotal;
    }
}