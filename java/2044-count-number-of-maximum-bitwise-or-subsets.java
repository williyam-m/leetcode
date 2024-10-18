class Solution {
    int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums)
            max |= n;
        findAllSubset(nums, new ArrayList<>(), 0, max);
        return ans;
    }
    private void findAllSubset(int[] nums, List<Integer> list, int i, int max) {
        if (i  == nums.length) {
            int x = 0;
            for (Integer n : list)
                x |= n;
            if (x == max)
               ++ans;
            return ;
        }
        findAllSubset(nums, list, i + 1, max);
        list.add(nums[i]);
        findAllSubset(nums, list, i + 1, max);
        list.remove(list.size() - 1);
        return ;
    }
}