class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count = 0;
            for (int j = i; j < nums.length; ++j) {
                count += nums[j] == target ? 1 : -1;
                if (count > 0) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}