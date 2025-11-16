class Solution {
    public int numSub(String s) {
        long ans = 0;
        int curr = 0;
        int currAns = 0;
        int mod = 1000000000 + 7;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ans += currAns;
                ans %= mod;
                curr = 0;
                currAns = 0;
            }
            else {
                ++curr;
                currAns += curr;
                currAns %= mod;
            }
        }
        if (curr > 0) {
            ans += currAns;
            ans %= mod;
        }
        return (int) ans;
    }
}