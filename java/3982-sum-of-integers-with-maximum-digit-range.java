class Solution {
    public int maxDigitRange(int[] nums) {
        int sum = 0;
        int maxDigitRange = 0;
        for (int num : nums) {
            int digitRange = calculateDigitRange(num);
            if (digitRange == maxDigitRange) {
                sum += num;
            }
            else if (digitRange > maxDigitRange) {
                sum = num;
                maxDigitRange = digitRange;
            }
        }
        return sum;
    }
    private int calculateDigitRange(int num) {
        int minDigit = num;
        int maxDigit = 0;
        while (num > 0) {
            minDigit = Math.min(minDigit, num % 10);
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit - minDigit;
    }
}