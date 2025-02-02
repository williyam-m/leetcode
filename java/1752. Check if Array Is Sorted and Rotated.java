class Solution {
    public boolean check(int[] nums) {
        int ans = 0;
        int size = nums.length;
        if (nums[0] < nums[size - 1])
           ++ans;
        for (int i = 1; i < size; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (++ans > 1)
                   return false;
            }
        }
        return true;
    }
}