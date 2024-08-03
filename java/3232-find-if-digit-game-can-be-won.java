class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumOfSingleDigits = 0;
        int sumOfDoubleDigits = 0;
        for (int num : nums) {
            if (num < 10)
               sumOfSingleDigits += num;
            else
               sumOfDoubleDigits += num;
        }
        return sumOfSingleDigits != sumOfDoubleDigits;
    }
}