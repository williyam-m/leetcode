class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        long curr = 1;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] == prices[i + 1] + 1) {
                ++curr;
            }
            else {
                curr = 1;
            }
            ans += curr;
        }
        return ans;
    }
}