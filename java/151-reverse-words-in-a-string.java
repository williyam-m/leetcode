class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int p2 = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') {
                --i;
            }
            sb.append(s.substring(i + 1, p2) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}