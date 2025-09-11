class Solution {
    public String sortVowels(String s) {
        List<Character> vowelsInS = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelsInS.add(c);
            }
        }
        Collections.sort(vowelsInS);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                ans.append(vowelsInS.get(i++));
            }
            else {
                ans.append(c);
            }
        }
        
        return ans.toString();
    }
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}