class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int i = 0;
        int n = s1.length();
        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                ++i;
                continue;
            }
            StringBuilder sub1 = new StringBuilder();
            StringBuilder sub2 = new StringBuilder();
            while (i < n && s1.charAt(i) != s2.charAt(i)) {
                sub1.append(s1.charAt(i));
                sub2.append(s2.charAt(i));
                ++i;
            }
            ans.add(new ArrayList<>(Arrays.asList(sub1.toString(), sub2.toString())));
            ++i;
        }
        return ans;
    }
}