class Solution {
    public String simplifyPath(String path) {
        String[] arr_path = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : arr_path) {
            if (s.length() > 0) {
                if (s.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (!s.equals(".")) {
                    stack.push(s);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/" + s);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}