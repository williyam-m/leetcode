class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
        /*
        int l = 0, r = s.length() - 1;
        while (l <= r && (s.charAt(l) == '0' || s.charAt(r) == '0')) {
            if (s.charAt(l) == '0') {
                ++l;
            } 
            if (s.charAt(r) == '0') {
                --r;
            }
        }
        return l <= r && !s.substring(l, r).contains("0");
        */
    }
}