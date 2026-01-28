class Solution {
    public int residuePrefixes(String s) {
        int[] count = new int[26];
        int residue = 0;
        int distinct = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (count[c - 'a']++ == 0) {
                ++distinct;
            }
            if (((i + 1) % 3) == distinct) {
                ++residue;
            }
            else if (distinct > 2) {
                break;
            }
        }
        return residue;
    }
}