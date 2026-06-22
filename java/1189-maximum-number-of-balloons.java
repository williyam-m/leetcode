class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            if (check(c)) {
                ++count[c - 'a'];
            }
        }
        
        int instances = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            if (check((char) (i + 'a'))) {
                instances = Math.min(instances, count[i] / neededCount((char) (i + 'a')));
            }
        }
        return instances;
    }
    private boolean check (char c) {
        switch (c) {
            case 'b':
            case 'a':
            case 'l':
            case 'o':
            case 'n':
                return true;
        }
        return false;
    }
    private int neededCount(char c) {
        switch (c) {
            case 'l':
            case 'o':
                return 2;
        }
        return 1;
    }
}