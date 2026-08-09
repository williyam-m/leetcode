class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double sum = 0;
        int j = discounts.length - 1;
        for (int i = prices.length - 1; i >= 0; --i) {
            sum += j >= 0 ? (double) (prices[i] * (100 - discounts[j--])) / 100 : prices[i];
        }
        return sum;
    }
}