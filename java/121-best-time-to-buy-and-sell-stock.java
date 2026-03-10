class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE, ans = 0;
        for (int price : prices) {
            minValue = Math.min(minValue, price);
            ans = Math.max(ans, price - minValue);
        }
        return ans;
    }
}