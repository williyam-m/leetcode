class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int rightOnes = 0;
        int leftZeros = 0;

        for (char c : s.toCharArray())
            if (c == '1')
               ++rightOnes;

        if (rightOnes == 0 || rightOnes == s.length())
           return s.length() - 1;
        
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '0') {
               ++leftZeros;
            }
            else {
                --rightOnes;
            }
            ans = Math.max(ans, leftZeros + rightOnes);
        }
        return ans;
    }
}