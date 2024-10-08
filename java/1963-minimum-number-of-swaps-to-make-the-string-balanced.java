class Solution {
    public int minSwaps(String s) {
        int unMatched = 0;
        for (char c : s.toCharArray()) {
            if (c == '[')
               ++unMatched;
            else if (c == ']' && unMatched > 0)
               --unMatched;
        }
        return (unMatched + 1) / 2;
    }
}