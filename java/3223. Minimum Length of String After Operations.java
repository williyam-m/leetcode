class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            ++count[c - 'a'];
        int ans = 0;
        for (int n : count) {
            if (n >= 3)
               ans += n % 2 == 0 ? 2 : 1;
            else
               ans += n;
        }
        return ans;
    }
}