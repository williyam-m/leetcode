class Solution {
    public int firstUniqueEven(int[] nums) {
        int[] count = new int[51];
        for (int n : nums) {
            if (n % 2 == 0) {
                ++count[n / 2];
            }
        }
        for (int n : nums) {
            if (n % 2 == 0 && count[n / 2] == 1) {
                return n;
            }
        }
        return -1;
    }
}