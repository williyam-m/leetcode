class Solution {
    public int numSteps(String s) {
        int operations = 0;
        int carry = 0;
        // i > 0 (skip the last one as we need one as answer)
        for (int i = s.length() - 1; i > 0; --i) {
            int digit = (s.charAt(i) - '0') + carry;

            if (digit == 1) {
                operations += 2;
                carry = 1;
            }
            else {
                ++operations;
            }
            /*
            curr.    ope.    carry
            0        1       0
            1        2       1
            2        1       1 
            (while curr = 2 comes under digit == 0 so only ++ope. but it always comes after 1 then the carry 1 still there (not cleared))
            */
        }
        return operations + carry;
    }
}