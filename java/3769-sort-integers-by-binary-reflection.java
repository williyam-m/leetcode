class Solution {
    public int[] sortByReflection(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i];
        }
        Arrays.sort(ans, (a, b) -> {
            int a_binary = convertToBinaryReflection(a);
            int b_binary = convertToBinaryReflection(b);
            if (a_binary != b_binary) {
                return a_binary - b_binary;
            }
            return a - b;
        });
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = ans[i];
        }
        return nums;
    }
    private int convertToBinaryReflection(int n) {
        return Integer.valueOf(new StringBuilder(Integer.toBinaryString(n)).reverse().toString(), 2);
    }
}