class Solution {
    public int secondHighest(String s) {
        int firstHighestNum = -1;
        int secoundHighestNum = -1;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                continue;
            }
            int num = c - '0';
            if (firstHighestNum == num) {
                continue;
            }
            if (firstHighestNum < num) {
                secoundHighestNum = firstHighestNum;
                firstHighestNum = num;
            }
            else if (secoundHighestNum < num) {
                secoundHighestNum = num;
            }
        }
        return secoundHighestNum;
    }
}