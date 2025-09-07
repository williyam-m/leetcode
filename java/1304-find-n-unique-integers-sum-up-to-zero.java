class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int currValue = 1;
        for (int i = 0; i < n - 1; ++i) {
            ans[i++] = -currValue;
            ans[i] = currValue++;
        }
        return ans;
    }
}