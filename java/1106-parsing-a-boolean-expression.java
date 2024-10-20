class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                List<Character> exp = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    exp.add(stack.pop());
                }
                stack.pop();
                if (!stack.isEmpty()) {
                    boolean ans;
                    char t = stack.pop();
                    if (t == '&') {
                        ans = true;
                        for (char i : exp) {
                            ans = ans && (i == 't' ? true : false);
                        }
                    }
                    else if (t == '|') {
                        ans = false;
                        for (char i : exp) {
                            ans = ans || (i == 't' ? true : false);
                        }
                    }
                    else
                        ans = exp.get(0) == 't' ? false : true;
                    
                    stack.push(ans == true ? 't' : 'f');
                }
            }
            else if (c != ',')
                stack.push(c);
        }
        return stack.peek() == 't';
    }
}