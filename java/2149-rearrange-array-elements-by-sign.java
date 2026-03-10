class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int num : nums) {
            if (num < 0) {
                ans[negativeIndex] = num;
                negativeIndex += 2;
            }
            else {
                ans[positiveIndex] = num;
                positiveIndex += 2;
            }
        }
        return ans;
    }
}