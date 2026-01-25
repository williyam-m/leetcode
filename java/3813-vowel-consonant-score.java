class Solution {
    public int vowelConsonantScore(String s) {
        int countOfConsonants = 0;
        int countOfVowels = 0;
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            if (isVowel(c)) {
                ++countOfVowels;
            }
            else {
                ++countOfConsonants;
            }
        }
        if (countOfConsonants <= 0) 
            return 0;

        return (int) Math.floor(countOfVowels / countOfConsonants);

    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u') {
            return true;
        }
        return false;
    }
}