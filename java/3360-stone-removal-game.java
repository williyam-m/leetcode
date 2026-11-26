class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;
        int turn = -1;
        while (n - stones >= 0) {
            n -= stones--;
            ++turn;
        }
        return turn % 2 == 0;
    }
}