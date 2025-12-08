class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for (int a = 1; a <= n; ++a) {
            for (int b = a + 1; b <= n; ++b) {
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && (a * a) + (b * b) == (c * c)) {
                   ans += 2;
                }
            }
        }
        return ans;
        /*int ans = 0;
        for (int a = 1; a <= n; ++a) {
            for (int b = a + 1; b <= n; ++b) {
                for (int c = b + 1; c <= n; ++c) {
                    if ((a * a) + (b * b) == (c * c)) {
                        ans += 2;
                    }
                }
            }
        }
        return ans;*/
    }
}