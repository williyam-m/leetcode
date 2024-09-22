class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String bannedWord : bannedWords)
            set.add(bannedWord);
        for (String msg : message) {
            if (set.contains(msg))
                if (++count == 2)
                    return true;
        }
        return false;
    }
}