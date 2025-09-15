class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLettersSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenLettersSet.add(c);
        }
        int canType = 0;
        for (String word : text.split(" ")) {
            for (char c : word.toCharArray()) {
                if (brokenLettersSet.contains(c)) {
                    --canType;
                    break;
                }
            }
            ++canType;
        }
        return canType;
    }
}