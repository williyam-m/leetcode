class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {return true;}
        for (int i = 0; i < s1.length() - 2; ++i) {
            if ( (s1.charAt(i) != s2.charAt(i) || s1.charAt(i+2) != s2.charAt(i+2)) && (s1.charAt(i) != s2.charAt(i+2) || s1.charAt(i+2) != s2.charAt(i)) ) {
                return false;
            } 
        }
        return true;
    }
}