class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.merge(nums[i], 1, Integer::sum);
            if (i >= k - 1) {
                int[][] count = new int[n][2];
                int j = 0;
                for (int m : map.keySet()) {
                    count[j][0] = m;
                    count[j++][1] = map.get(m);
                }
                Arrays.sort(count, (a, b) -> (a[1] != b[1]) ? (b[1] - a[1]) : (b[0] - a[0]));

                for (int l = 0; l < x; ++l) {
                    ans[i - k + 1] += count[l][0] * count[l][1];
                }
            
                map.merge(nums[i - k + 1], -1, Integer::sum);
                if (map.get(nums[i - k + 1]) == 0)
                   map.remove(nums[i - k + 1]);
            }
        }
        return ans;
    }
}