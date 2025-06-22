class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int l = (n + k - 1) / k;
        String[] ans = new String[l];
        for (int i = 0; i < l; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = (i * k); j < (i * k) + k; ++j) {
                sb.append((j < n) ? s.charAt(j) : fill);
            }
            ans[i] = sb.toString();
        }

        return ans;
    }
}