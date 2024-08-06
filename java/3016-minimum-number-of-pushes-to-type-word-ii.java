class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray())
            ++count[c - 'a'];
        Arrays.sort(count);
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans += (count[25 - i] * (i / 8 + 1));
        }
        return ans;
    }
}