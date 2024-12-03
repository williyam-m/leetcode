class Solution {
    public String countAndSay(int n) {
        if (n == 1)
           return "1";
        String ans = "1";
        for (int i = 0; i < n - 1; ++i) {
            ans = RLE(ans);
        }
        return ans;
    }
    private String RLE(String ans) {
        int n = ans.length();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            if (ans.charAt(i) != ans.charAt(i + 1)) {
                sb.append("" + count + ans.charAt(i));
                count = 1;
            }
            else 
               ++count;
        }
        sb.append("" +count + ans.charAt(n - 1));
        return sb.toString();
    }
}