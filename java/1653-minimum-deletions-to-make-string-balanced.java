class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int deleteCount = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                ++deleteCount;
            }
            else {
                stack.push(c);
            }
        }
        return deleteCount;
    }
}