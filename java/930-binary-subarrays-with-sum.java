class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            int key = prefix - goal;
            if (map.containsKey(key))
                ans += map.get(key);
            map.merge(prefix, 1, Integer::sum);
        }
        return ans;
    }
}