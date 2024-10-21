class Solution {
    int ans = 0;
    public int maxUniqueSplit(String s) {
        subset(s, 0, new HashSet<>());
        return ans;
    }
    private void subset (String s, int start, Set<String> set){
        if (start == s.length()) {
            ans = Math.max(ans, set.size());
            return ;
        }
        for (int i = start + 1; i <= s.length(); ++i) {
            if (!set.contains(s.substring(start, i))) {
                set.add(s.substring(start, i));
                subset(s, i, set);
                set.remove(s.substring(start, i));
            }
        }
    }
}