class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(convertToBinary((int) c, 8));
        }
        return isPalindromic(sb);
    }
    private String convertToBinary(int n, int bit) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ('0' + (n % 2)));
            n /= 2;
        }
        while (bit > sb.length()) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }
    private boolean isPalindromic(StringBuilder sb) {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l++) != sb.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}