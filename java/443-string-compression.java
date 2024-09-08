class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        for (int i = 0; i < n; ++i, ++index) {
            int len = 1;
            chars[index] = chars[i];
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                ++len;
                ++i;
            }

            if (len > 1) {
                for (char c : ("" + len).toCharArray())
                    chars[++index] = c;
            }
        }
        return index;
    }
}