class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty())
                stack.push(c);
            else if (stack.peek() == 'A' && c == 'B')
                stack.pop();
            else if (stack.peek() == 'C' && c == 'D')
                stack.pop();
            else
                stack.push(c);
        }

        return stack.size();
    }
}