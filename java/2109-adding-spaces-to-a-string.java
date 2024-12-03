class Solution {
    public String addSpaces(String s, int[] spaces) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int s_len = s.length(), spaces_len = spaces.length;
        for (int i = 0; i < s_len; ++i) {
            if (index < spaces_len && spaces[index] == i) {
                sb.append(" ");
                ++index;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}