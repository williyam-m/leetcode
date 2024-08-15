class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 20) {
                if ((five < 1 || ten < 1) && five < 3)
                   return false;
                if (ten < 1) {
                    five -= 3;
                }
                else {
                    --five;
                    --ten;
                }
            }
            else if (bill == 10) {
                if (five < 1)
                   return false;
                --five;
                ++ten;
            }
            else
                ++five;
        }
        return true;
    }
}