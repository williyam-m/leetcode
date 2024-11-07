class Solution {
    public int largestCombination(int[] candidates) {
        int maxBit = 24;
        int ans = 0;
        for (int i = 0; i < maxBit; ++i) {
            int count = 0;
            for (int c : candidates) {
                if ((c >> i & 1) == 1)
                   ++count;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}