class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder ans = getBinaryStr(n);
        return ans.charAt(k - 1);
    }
    private StringBuilder getBinaryStr(int n) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n; ++i) {
            StringBuilder prev = reverse(invert(new StringBuilder(sb)));
            sb.append("1" + prev.toString());
        }
        return sb;
    }
    private StringBuilder invert(StringBuilder sb1) {
        for (int i = 0; i < sb1.length(); ++i) {
            if (sb1.charAt(i) == '0')
               sb1.setCharAt(i, '1');
            else
               sb1.setCharAt(i, '0');
        }
        return sb1;
    }
    private StringBuilder reverse(StringBuilder sb1) {
        int l = 0; 
        int r = sb1.length() - 1;
        while (l < r) {
            char temp = sb1.charAt(l);
            sb1.setCharAt(l++, sb1.charAt(r));
            sb1.setCharAt(r--, temp);
        }
        return sb1;
    }
}