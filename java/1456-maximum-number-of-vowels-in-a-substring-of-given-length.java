class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (isVowel(s.charAt(i)))
                ++curr;
            if (i >= k && isVowel(s.charAt(i - k)))
                --curr;
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}