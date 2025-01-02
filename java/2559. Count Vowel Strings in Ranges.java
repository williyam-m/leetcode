class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordsLen = words.length;
        int queriesLen = queries.length;
        int[] ans = new int[queries.length];
        int[] prefix = new int[wordsLen + 1];
        int count = 0;

        for (int i = 0; i < wordsLen; ++i) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)))
                ++count;
            prefix[i + 1] = count;
        }

        for (int i = 0; i < queriesLen; ++i) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }

        return ans;
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}