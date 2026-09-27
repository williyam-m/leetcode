class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.length());
            }
            else if (c == ')') {
                reverse(sb, stack.pop(), sb.length() - 1);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(end);
            sb.setCharAt(end--, sb.charAt(start));
            sb.setCharAt(start++, temp);
        }
    }
}