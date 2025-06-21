class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        boolean isFirstChar = true;
        for (int i = 0; i < caption.length() && sb.length() < 100; ++i) {
            if (caption.charAt(i) == ' ') {
                continue;
            }

            if (isFirstChar || caption.charAt(i - 1) != ' ') {
                sb.append(Character.toLowerCase(caption.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(caption.charAt(i)));
            }
            isFirstChar = false;
        }
        return sb.toString();
    }
}