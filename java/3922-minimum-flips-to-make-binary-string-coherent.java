class Solution {
    public int minFlips(String s) {
        // case 1 : all 1 or 0
        // case 2 : one 1 on center
        // case 3 : two 1 on edge (1.00...1)
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ++zeros;
            }
        }
        int ones = s.length() - zeros;
        if (zeros == 0 || ones == 0) {
            return 0;
        }
        ones -= ((s.charAt(0) - '0') & (s.charAt(s.length() - 1) - '0')) + 1;
        return Math.min(zeros, ones);
    }
}