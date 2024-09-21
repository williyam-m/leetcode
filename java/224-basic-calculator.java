class Solution {
    public int calculate(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            } else if (c == '+' || c == '-') {
                ans += num * sign;
                sign = (c == '+' ? 1 : -1) * stack.peek();
                num = 0;
            }
        }
        return ans + num * sign;
    }
}