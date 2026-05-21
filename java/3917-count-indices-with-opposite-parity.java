class Solution {
    public int[] countOppositeParity(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] % 2 == 0) {
                nums[i] = oddCount;
                ++evenCount;
            }
            else {
                nums[i] = evenCount;
                ++oddCount;
            }
        }
        return nums;
    }
}