class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums)
            sum += num;
        int remainder = (int) (sum % p);
        if (remainder == 0)
            return 0;

        int prefix = 0;
        int ans = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            prefix %= p;
            int target = (prefix - remainder + p) % p;
            if (map.containsKey(target))
                ans = Math.min(ans, i - map.get(target));
            map.put(prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}