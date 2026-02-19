class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, curr = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
            else {
                ++curr;
            }
        }
        return ans + Math.min(prev, curr);
        /*
        int currentOnesCount = 0;
        int currentZerosCount = 0;
        int ans = 0;
        char prevChar = '0';
        for (char currChar : s.toCharArray()) {
            if (currChar != prevChar && currentZerosCount > 0 && currentOnesCount > 0) {
                ans += Math.min(currentZerosCount, currentOnesCount);
                if (prevChar == '0') {
                    currentOnesCount = 0;
                }
                else {
                    currentZerosCount = 0;
                }
            }
            if (currChar == '0') {
                ++currentZerosCount;
            }
            else {
                ++currentOnesCount;
            }
            prevChar = currChar;
        }
        return ans + Math.min(currentZerosCount, currentOnesCount);
        */
    }
}