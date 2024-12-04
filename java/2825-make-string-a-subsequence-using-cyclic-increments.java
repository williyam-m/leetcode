class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str2_len = str2.length();
        int p2 = 0;
        for (int i = 0; i < str1.length(); ++i) {
            if (p2 == str2_len)
               break;

            if (str1.charAt(i)  == str2.charAt(p2))
               ++p2;
            else if ((char) ((str1.charAt(i) + 1 - 'a') % 26) + 'a'  == str2.charAt(p2))
               ++p2;
        }
        return p2 == str2_len ? true : false;
    }
}