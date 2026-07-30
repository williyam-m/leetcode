class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int groups = ((n - 1) / 8) + 1;
        int ans = 4 * groups * (groups - 1);
        return ans + (n - ((groups - 1) * 8)) * groups; // + remaining

        /* solution 1"
        int ans = 0;
        for (int i = 0; i < word.length(); ++i) {
            ans += (i / 8) + 1;
        }
        return ans;
        */

        /* solution 2 : "not distinct"
        if all letters in word are not distinct
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
        */
    }
}