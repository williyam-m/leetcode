class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] count = new int[101];
        for (int n : nums) {
            ++count[n];
        }
        int ans = 0;
        for (int i = 0; i < 101; ++i) {
            if (count[i] != 0 && count[i] % k == 0) {
                ans += i * count[i];
            }
        }
        return ans;
    }
}