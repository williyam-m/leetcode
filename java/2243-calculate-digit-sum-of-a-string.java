class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int i = 0;
            for (;i < n - k; i += k) {
                sb.append(findSum(s.substring(i, i + k)));
            }
            if (i < n) {
                sb.append(findSum(s.substring(i, n)));
            }
            s = sb.toString();
        }
        return s;
    }
    private String findSum (String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return "" + sum;
    }
}