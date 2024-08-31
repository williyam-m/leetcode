class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isAlmostEqual(nums[i], nums[j]) || isAlmostEqual(nums[j], nums[i])) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private boolean isAlmostEqual(int num1, int num2) {
        if (num1 == num2)
            return true;

        char[] chars = String.valueOf(num1).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                chars[i] = chars[j];
                chars[j] = temp;

                if (Integer.parseInt(String.valueOf(chars)) == num2)
                    return true;

                chars[j] = chars[i];
                chars[i] = temp;
            }
        }
        return false;
    }
}