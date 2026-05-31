class Solution {
    public List<Integer> findValidElements(int[] nums) {
        boolean[] rightToLeft = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = nums.length - 1; i >= 0; --i) {
            rightToLeft[i] = maxValue < nums[i] ? true :false;
            maxValue = Math.max(maxValue, nums[i]);
        }
        maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (maxValue < nums[i] || rightToLeft[i]) {
                ans.add(nums[i]);
            }
            maxValue = Math.max(maxValue, nums[i]);
        }
        return ans;
    }
}