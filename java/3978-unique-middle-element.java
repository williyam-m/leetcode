class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int middleElement = nums[nums.length / 2];
        int middleElementCount = 0;
        for (int num : nums) {
            if (num == middleElement) {
                ++middleElementCount;
            }
            if (middleElementCount > 1) {
                return false;
            }
        }
        return middleElementCount == 1;
    }
}