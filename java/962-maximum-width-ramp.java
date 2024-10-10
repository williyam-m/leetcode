class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()])
                ans = Math.max(ans, i - stack.pop());
        }
        return ans;
    }
}