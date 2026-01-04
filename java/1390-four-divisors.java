class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int currSum = 0;
            int count = 0;
            int root = (int) Math.sqrt(num);
            for (int i = 1; i <= root; ++i) {
                if (num % i != 0) {
                    continue;
                }
                int j = num / i;
                if (i == j) {
                    currSum += i;
                    count += 1;
                }
                else {
                    currSum += i + j;
                    count += 2;
                }
                if (count > 4) {break;}
            }
            if (count == 4) {
                sum += currSum;
            }
        }
        return sum;
    }
}