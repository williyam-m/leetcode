class Solution {
    public String largestEven(String s) {
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '2')
                break;
            --i;
        }
        return s.substring(0, i + 1);
    }
}