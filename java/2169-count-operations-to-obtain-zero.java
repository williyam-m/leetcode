class Solution {
    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 > 0 && num2 > 0) {
            int times = 0;
            if (num1 > num2) {
                times = num1 / num2;
                num1 -= num2 * times;
            }
            else {
                times = num2 / num1;
                num2 -= num1 * times;
            }
            ans += times;
        }
        return ans;
    }
}