class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while (word.length() < k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); ++i)
                sb.append((char) ((((word.charAt(i) - 'a') + 1) % 26) + 'a'));
            word.append(sb);
        }
        return word.charAt(k - 1);
    }
}