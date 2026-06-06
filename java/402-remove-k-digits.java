class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int n = c - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() > n) {
                stack.pop();
                --k;
            }
            if (!(stack.isEmpty() && n == 0)) {
                stack.push(n);
            }
        }
        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for (Integer c : stack) {
            sb.append(c);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}