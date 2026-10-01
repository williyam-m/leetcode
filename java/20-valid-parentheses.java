class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            }
            else if (stack.isEmpty() || !isValid(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isValid (char open, char close) {
        if (open == '(' && close != ')') {
            return false;
        }
        else if (open == '{' && close != '}') {
            return false;
        }
        else if (open == '[' && close != ']') {
            return false;
        }
        return true;
    }
    private boolean isOpenBracket(char c) {
        return (c == '(' || c == '{' || c == '[');
    }
}