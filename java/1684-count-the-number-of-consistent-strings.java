class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray())
            set.add(c);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    --ans;
                    break;
                }
            }
            ++ans;
        }
        return ans;
    }
}