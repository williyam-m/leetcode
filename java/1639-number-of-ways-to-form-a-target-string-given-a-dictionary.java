class Solution {
    public int numWays(String[] words, String target) {
        int kMod = 1_000_000_007;
        int n = words[0].length();
        int len = target.length();
        long[] dp = new long[len + 1];
        dp[0] = 1;

        for (int i = 0; i < n; ++i) {
            int[] count = new int[26];
            for (String word : words)
                ++count[word.charAt(i) - 'a'];
            for (int j = len; j > 0; --j) {
                dp[j] += dp[j - 1] * count[target.charAt(j - 1) - 'a'];
                dp[j] %= kMod;
            }
        }
        return (int) dp[len];
    }
}