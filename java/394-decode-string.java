class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[')
                    sb.append(stack.pop());
                stack.pop(); //'['

                String n = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    n = stack.pop() + n;
                
                char[] arr = (sb.reverse().toString()).toCharArray();
                for (int i = 0; i < Integer.parseInt(n); ++i) {
                    for (char a : arr)
                        stack.push(a);
                }
            }
            else
               stack.push(c);
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stack)
           ans.append(c);
        
        return ans.toString();
    }
}