class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        ans.add("a");
        int i = 0;
        while (!target.equals(ans.get(i))) {
            String s = ans.get(i);
            if (target.substring(0, s.length()).equals(s))
                ans.add(s + 'a');
            else
                ans.add(s.substring(0, s.length() - 1) + (char) (s.charAt(s.length() - 1) + 1));
            ++i;
        }
        return ans;
    }
}