class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];

        while (l < r) {
            int m = (l + r) / 2;
            if (countOfPairsGreaterThanMid(nums, m, n) >= k)
               r = m;
            else
               l = m + 1;
        }
        return l;
    }
    private int countOfPairsGreaterThanMid(int[] nums, int m, int n) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j < n && nums[i] - nums[j] > m)
               ++j;
            count += i - j;
        }
        return count;
    }
}