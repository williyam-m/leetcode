class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(digits, ans, 0, new StringBuilder());
        return ans;
    }

    private String[] map = {"", "", "abc", "def", "ghi",
    "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void backtrack(String digits, List<String> ans, int i, StringBuilder sb) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return ;
        }

        for (char c : map[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            backtrack(digits, ans, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}