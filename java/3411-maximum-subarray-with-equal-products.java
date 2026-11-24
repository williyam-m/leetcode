class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= i; --j) {
                if (isProductEquivalent(i, j, nums, n)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    private boolean isProductEquivalent(int i, int j, int[] nums, int n) {
        int product = nums[i];
        int gcd = nums[i];
        int lcm = nums[i];
        for (int k = i + 1; k <= j; ++k) {
            product *= nums[k];
            if (gcd != 1) {
                gcd = findGcd(gcd, nums[k]);
            }
            lcm = (lcm / findGcd(lcm, nums[k])) * nums[k];
        }
        return product == gcd * lcm;
    }
    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}