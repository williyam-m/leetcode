class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[nums[n - 1] + 1];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (++count[num] <= k) {
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}