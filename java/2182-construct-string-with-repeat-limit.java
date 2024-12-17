class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        int pendingIndex = -1;
        for (int i = 25; i >= 0; --i) {
            if (count[i] == 0)
                continue;
            
            if (pendingIndex > 0) {
                ans.append((char) ('a' + i));
                --count[i];
                i = pendingIndex;
                pendingIndex = -1;
            }
            else {
                for (int j = 0; j < repeatLimit && count[i]-- > 0; ++j)
                    ans.append((char) ('a' + i));
                if (count[i] > 0)
                   pendingIndex = i + 1;
            }
        }
        return ans.toString();
    }
}