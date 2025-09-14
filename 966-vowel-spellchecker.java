class Solution {
    Set<String> words_perfect;
    Map<String, String> words_cap;
    Map<String, String> words_vow;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        words_perfect = new HashSet();
        words_cap = new HashMap();
        words_vow = new HashMap();
        String[] ans = new String[queries.length];
        for (String word : wordlist) {
            words_perfect.add(word);
            String wordLow = word.toLowerCase();
            words_cap.putIfAbsent(wordLow, word);
            String wordLowDV = deVowel(wordLow);
            words_vow.putIfAbsent(wordLowDV, word);
        }
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = solve(queries[i]);
        }
        return ans;
    }
    private String solve (String word) {
        if (words_perfect.contains(word)) {
            return word;
        }
        String wordLow = word.toLowerCase();
        if (words_cap.containsKey(wordLow)) {
            return words_cap.get(wordLow);
        }
        String wordLowDV = deVowel(wordLow);
        if (words_vow.containsKey(wordLowDV)) {
            return words_vow.get(wordLowDV);
        }
        return "";
    }
    private String deVowel (String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }
    private boolean isVowel (char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
