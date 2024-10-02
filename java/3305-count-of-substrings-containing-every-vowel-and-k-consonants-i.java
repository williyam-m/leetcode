class Solution {
    public int countOfSubstrings(String word, int k) {
        int ans = 0;

        for (int p1 = 0; p1 < word.length(); ++p1) {
            int a = 0;
            int e = 0;
            int i = 0;
            int o = 0;
            int u = 0;
            int consonant = 0;
            for (int p2 = p1; p2 < word.length(); ++p2) {
                char c = word.charAt(p2);
                if (c == 'a')
                   ++a;
                else if (c == 'e')
                   ++e;
                else if (c == 'i')
                   ++i;
                else if (c == 'o')
                   ++o;
                else if (c == 'u')
                   ++u;
                else
                  ++consonant;

                if (a >= 1 && e >= 1 && i >= 1 && o >= 1 && u >= 1 && consonant == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}