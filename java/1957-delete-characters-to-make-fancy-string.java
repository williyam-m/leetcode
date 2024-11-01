class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i > 0 && s.charAt(i - 1) == c) {
                if (++curr >= 2)
                   continue;
            }
            else
                curr = 0;
            sb.append(c);
        }
        return sb.toString();
    }
}