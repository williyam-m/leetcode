class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] count = new int[26];

        for (char c : s1.toCharArray())
           ++count[c - 'a'];
        
        int n = s1.length();

        for (int i = 0; i < s2.length(); ++i) {
            --count[s2.charAt(i) - 'a'];
            if (i < n - 1)
                continue;

            if (check(count)) {
               return true;
            }
            ++count[s2.charAt(i - n + 1) - 'a'];
        }
        return false;
    }
    private boolean check (int[] count) {
        for (int c : count) {
            if (c != 0)
               return false;
        }
        return true;
    }
}