class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 2; i <= n; ++i) {
            StringBuilder invertStr = invert(sb);
            sb.append('1').append(invertStr.reverse());
            if (sb.length() >= k) {
                return sb.charAt(k - 1);
            }
        }
        return '0';
    }
    private StringBuilder invert(StringBuilder sb) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length(); ++i) {
            ans.append(sb.charAt(i) == '1' ? '0' : '1');
        }
        return ans;
    }
}