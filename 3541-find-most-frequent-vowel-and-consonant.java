class Solution {
    public int maxFreqSum(String s) {
        int maxFreqOfVowel = 0;
        int maxFreqOfConsonant = 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (isVowel((char) (i + (int) 'a'))) {
                maxFreqOfVowel = Math.max(maxFreqOfVowel, count[i]);
            }
            else {
                maxFreqOfConsonant = Math.max(maxFreqOfConsonant, count[i]);
            }
        }
        return maxFreqOfVowel + maxFreqOfConsonant;
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
