class Solution {
    public String trimTrailingVowels(String s) {
        for (int i = s.length() - 1; i >= 0; --i) {
            if (!isVowel(s.charAt(i))) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}