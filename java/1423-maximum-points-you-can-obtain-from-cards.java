class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, ans = 0;
        for (int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }
        int j = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; --i) {
            ans = Math.max(ans, sum);
            sum -= cardPoints[i];
            sum += cardPoints[j--];
        }
        return Math.max(ans, sum);
    }
}