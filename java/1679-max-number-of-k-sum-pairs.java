class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : nums)
            map.merge(n, 1, Integer::sum);

        for (int n : map.keySet()) {
            if (map.containsKey(k - n)) {
                ans += Math.min(map.get(k - n), map.get(n));
            }
        }
        return ans / 2;

        /*
         * Arrays.sort(nums);
         * int ans = 0;
         * int l = 0, r = nums.length - 1;
         * while (l < r) {
         * if (nums[l] + nums[r] == k) {
         * ++ans;
         * ++l;
         * --r;
         * } else if (nums[l] + nums[r] < k)
         * ++l;
         * else
         * --r;
         * }
         * return ans;
         */
    }
}