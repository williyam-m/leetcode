class Solution {
    public String reversePrefix(String s, int k) {
        return reverse(s.substring(0, k)) + s.substring(k, s.length());
    }

    private String reverse(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            char temp = str.charAt(i);
            str.setCharAt(i++, str.charAt(j));
            str.setCharAt(j--, temp);
        }
        return str.toString();
    }
    
    /*
    private String reverse(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
    */
}