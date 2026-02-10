class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            int evenCount = 0;
            int oddCount = 0;
            for (int j = i; j < n; ++j) {
                if (set.add(nums[j])) {
                    if (nums[j] % 2 == 0) {
                        ++evenCount;
                    }
                    else {
                        ++oddCount;
                    }
                }
                if (evenCount == oddCount) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}