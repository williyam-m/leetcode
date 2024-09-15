class Solution {
    public int findTheLongestSubstring(String s) {
        String vowels = "aeiou";
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;
        int ans = 0;
        int mask = 0;
        for (int i = 0; i < s.length(); ++i) {
            int index = vowels.indexOf(s.charAt(i));
            if (index != -1)
                mask ^= 1 << index;

            int prefix = map[mask];
            if (prefix == -2)
                map[mask] = i;
            else
                ans = Math.max(ans, i - prefix);
        }
        return ans;
    }
}