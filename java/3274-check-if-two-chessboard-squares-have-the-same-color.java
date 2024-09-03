class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1_col = coordinate1.charAt(0) - 'a' + 1;
        int c1_row = coordinate1.charAt(1) - '0';
        int c2_col = coordinate2.charAt(0) - 'a' + 1;
        int c2_row = coordinate2.charAt(1) - '0';
        if ((c1_col + c1_row) % 2 == (c2_col + c2_row) % 2)
           return true;
        return false;
    }
}