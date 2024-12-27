class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int prev = 0;
        for (int value : values) {
            ans = Math.max(ans, prev + value);
            prev = Math.max(prev, value) - 1;
        }

        return ans;
    }
}