class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        for (String word : words2) {
            int[] count = new int[26];
            for (char c : word.toCharArray())
                maxCount[c - 'a'] = Math.max(maxCount[c - 'a'], ++count[c - 'a']);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words1) {
            if (isUniverse(word, maxCount))
               ans.add(word);
        }
        return ans;
    }
    private boolean isUniverse(String word, int[] maxCount) {
        int[] count = new int[26];

        for (char c : word.toCharArray())
            ++count[c - 'a'];

        for (int i = 0; i < 26; ++i) {
            if (count[i] < maxCount[i])
               return false;
        }
        return true;
    }
}