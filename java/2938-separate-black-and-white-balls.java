class Solution {
    public long minimumSteps(String s) {
        int one = 0;
        long ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '1')
                ++one;
            else
                ans += one;
        }
        return ans;
    }
}