class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        ans[n - 1] = nums[1];
        int p1 = 0;
        int p2 = n - 1;
        for (int i = 2; i < n; ++i) {
            if (ans[p1] > ans[p2]) {
                ans[++p1] = nums[i];
            }
            else {
                ans[--p2] = nums[i];
            }
        }
        reverse(ans, p2, n - 1);
        return ans;
    }
    private void reverse(int[] ans, int p1, int p2) {
        while (p1 < p2) {
            int temp = ans[p1];
            ans[p1++] = ans[p2];
            ans[p2--] = temp;
        }
    }
}