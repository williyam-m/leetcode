class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String s1 = helper(String.valueOf(num1));
        String s2 = helper(String.valueOf(num2));
        String s3 = helper(String.valueOf(num3));
        char[] ans = new char[4];
        for (int i = 0; i < 4; ++i) {
            ans[i] = (char) (Math.min(s1.charAt(i) - '0', Math.min(s2.charAt(i) - '0', s3.charAt(i) - '0')) + '0');
        }
        return Integer.valueOf(new String(ans));
    }
    private String helper(String s) {
        int n = s.length();
        if (n == 1)
           return "000" + s;
        if (n == 2)
           return "00" + s;
        if (n == 3)
           return "0" + s;
        return s;
    }
}