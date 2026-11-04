class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = s.length;
        int i = 0;
        int ans = 0;
        for (int content : g) {
            while (i < n && s[i] < content) {
                ++i;
            }
            if (i == n) {
                break;
            }
            ++ans;
            ++i;
        }
        return ans;
    }
}