class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        int xCount = 0;
        for (char c : s.toCharArray()) {
            if (c == x) {
                ++xCount;
                continue;
            }
            sb.append(c);
        }
        while (--xCount >= 0) {
            sb.append(x);
        }
        return sb.toString();
    }
}