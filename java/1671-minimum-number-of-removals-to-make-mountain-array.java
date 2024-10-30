class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j])
                   LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j])
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
            }
        }

        int mountain = 0;
        for (int i = 0; i < n; ++i) {
            if (LIS[i] > 0 && LDS[i] > 0)
               mountain = Math.max(mountain, LIS[i] + LDS[i] + 1);
        }

        return n - mountain;
    }
}