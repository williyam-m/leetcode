class Solution {
    public int smallestRepunitDivByK(int k) {
        int reminder = 0;
        for (int lengthN = 1; lengthN <= k; ++lengthN) {
            reminder = (reminder * 10 + 1) % k;
            if (reminder == 0) {
                return lengthN;
            }
        }
        return -1;
    }
}