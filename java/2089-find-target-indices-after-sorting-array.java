class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTarget = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < target) {
                ++lessThanTarget;
            }
            else if (nums[i] == target) {
                ++count;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = lessThanTarget; i < lessThanTarget + count; ++i) {
            ans.add(i);
        }
        return ans;
        /*
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i < n; ++i) {
            if (nums[i] > target) {
                break;
            }
            else if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;
        */
    }
}