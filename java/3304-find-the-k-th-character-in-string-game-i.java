class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while (k > word.length()) {
            word.append(generateNext(word));
        }
        return word.charAt(k - 1);
    }
    private StringBuilder generateNext(StringBuilder sb) {
        StringBuilder ans = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            ans.append((char) ((((int) (c - 'a') + 1) % 26) + 'a'));
        }
        return ans;
    }
}