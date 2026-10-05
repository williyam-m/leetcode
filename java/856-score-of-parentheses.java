class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                int val;
                if (stack.peek() == '(') {
                    val = 1;
                }
                else {
                    val = (stack.pop() - '0') * 2;
                }
                stack.pop();
                while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != ')') {
                    val += stack.pop() - '0';
                }
                stack.push((char) (val + '0'));
            } 
            else { // '('
                stack.push(c);
            }
        }
        return stack.pop() - '0';
    }
}