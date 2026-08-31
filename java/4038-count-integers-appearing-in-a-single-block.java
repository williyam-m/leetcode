class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(nums[i])) {
                int curr = map.get(nums[i]);
                if (curr == 1) {
                    --ans;
                }
                map.put(nums[i], curr + 1);
            }
            else {
                map.put(nums[i], 1);
                ++ans;
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return ans;
    }
}