class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        char[] ans = new char[n / k];
        int index = 0;
        for (int i = 0; i < n; ) {
            String s1 = s.substring(i, i + k);
            int t = 0;
            for (char c : s1.toCharArray()) {
                t += (c - 'a');
                t %= 26;
            }
            ans[index++] = (char) (t + 'a'); 
            i += k;
        }
        return new String(ans);
    }
}