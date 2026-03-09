class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int ans = 0;
        for (int num : nums) {
            if (majority == 0) {
                ans = num;
            }
            majority += ans == num ? 1 : -1;
        }
        return ans;
    }
}