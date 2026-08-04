class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] + 1 != nums[i]) {
                addValues(nums[i - 1] + 1, nums[i], ans);
            }
        }
        return ans;
    }
    private void addValues(int start, int stop, List<Integer> ans) {
        for (int n = start; n < stop; ++n) {
            ans.add(n);
        }
    }
}