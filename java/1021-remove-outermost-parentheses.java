class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int val = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                --val;
            }
            if (val > 0) {
                sb.append(c);
            }
            if (c == '(') {
                ++val;
            }
        }
        return sb.toString();
    }
}