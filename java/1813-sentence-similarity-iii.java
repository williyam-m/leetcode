class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] word1 = sentence1.split(" ");
        String[] word2 = sentence2.split(" ");
        return word1.length > word2.length ? helper(word2, word1) : helper(word1, word2);
    }

    private boolean helper(String[] word1, String[] word2) {
        int l1 = 0;
        int r1 = word1.length - 1;
        int r2 = word2.length - 1;
        if (r1 == 0)
            return word1[0].equals(word2[0]) || word1[0].equals(word2[r2]);

        while (l1 <= r1) {
            if (!word1[l1].equals(word2[l1])) {
                --l1;
                break;
            }
            ++l1;
        }

        while (r1 > l1) {
            if (!word1[r1].equals(word2[r2])) {
                break;
            }
            --r1;
            --r2;
        }
        return (l1 >= r1) ? true : false;
    }
}