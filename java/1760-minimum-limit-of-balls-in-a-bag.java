class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();

        while (l < r) {
            int m = (l + r) / 2;
            if (operation(nums, m) <= maxOperations)
               r = m;
            else
               l = m + 1;
        }
        return l;
    }
    private int operation(int[] nums, int m) {
        int ans = 0;
        for (int n : nums)
            ans += (n - 1) / m;
        return ans;
    }
}