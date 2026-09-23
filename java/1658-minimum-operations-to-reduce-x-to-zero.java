class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == x) {
            return n;
        }
        else if (sum < x) {
            return -1;
        }
        int curr = 0;
        int ans = -1;
        int right = 0, left = 0;
        while (right < n) {
            curr += nums[right++];
            while (sum - x < curr && left < right) {
                curr -= nums[left++];
            }
            if (curr == sum - x) {
                ans = Math.max(ans, right - left);
            }
        }

        return ans == -1 ? -1 : n - ans;
    }
}