class Solution {
    public int minimumPushes(String word) {
        int n = 26;
        int[] count = new int[n];
        for (char c : word.toCharArray()) {
            ++count[c - 'a'];
        }
        Arrays.sort(count);
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (count[i] == 0) {
                break;
            }
            ans += count[i] * (((n - 1 - i) / 8) + 1);
        }
        return ans;
    }
}