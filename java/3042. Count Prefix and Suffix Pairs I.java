class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefixAndSuffix(words[i], words[j]))
                   ++ans;
            }
        }
        return ans;
    }
    private boolean isPrefixAndSuffix(String w1, String w2) {
        if (w1.length() > w2.length())
           return false;
        return w2.startsWith(w1) && w2.endsWith(w1);
    }
}