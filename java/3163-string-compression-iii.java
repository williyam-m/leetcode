class Solution {
    public String compressedString(String word) {
        int count = 0, len = word.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; ++i) {
            ++count;
            if (count == 9 || word.charAt(i) != word.charAt(i + 1)) {
                sb.append("" + count + word.charAt(i));
                count = 0;
            }
        }
        if (len == 1 || word.charAt(len - 2) != word.charAt(len - 1)) {
            sb.append("" + 1 + word.charAt(len - 1));
        }
        else {
            sb.append("" + ++count + word.charAt(len - 1));
        }
        return sb.toString();
    }
}