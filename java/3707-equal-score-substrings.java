class Solution {
    public boolean scoreBalance(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'a' + 1;
        }
        int curr = 0;
        for (char c : s.toCharArray()) {
            curr += c - 'a' + 1;
            if (2 * curr == sum) {
                return true;
            }
            else if (2 * curr > sum) {
                return false;
            }
        }
        return false;
    }
}