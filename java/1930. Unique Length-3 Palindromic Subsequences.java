class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        int n = s.length();
        int[][] index = new int[26][2];
        for (int[] i : index)
            Arrays.fill(i, -1);
        
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (index[c - 'a'][0] == -1) {
                index[c - 'a'][0] = i;
            }
            else {
                index[c - 'a'][1] = i;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (index[i][0] == -1 || index[i][1] == -1)
               continue;
            int l = index[i][0];
            int r = index[i][1];
            Set<Integer> set = new HashSet<>();
            for (int j = l + 1; j < r; ++j) {
                set.add(s.charAt(j) - 'a');
            }
            ans += set.size();
        }
        return ans;
    }
}