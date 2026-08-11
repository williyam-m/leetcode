class Solution {
    public int missingInteger(int[] nums) {
        int ans = nums[0];
        boolean isFound = false;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        
        for (int i = 1; i < nums.length; ++i) {
            if (!isFound) {
                if (nums[i - 1] + 1 == nums[i]) {
                    ans += nums[i];
                }
                else{
                    isFound = true;
                }
            }
            set.add(nums[i]);
        }

        while (set.contains(ans)) {
            ++ans;
        }
        return ans;
    }
}