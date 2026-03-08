class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int len = (int) Math.pow(2, n);
        int[] set = new int[len];
        for (String num : nums) {
            ++set[Integer.parseInt(num, 2)];
        }
        for (int i = 0; i < len; ++i) {
            if (set[i] == 0) {
                String ans = Integer.toBinaryString(i);
                return "0".repeat(n - ans.length()) + ans;
            }
        }
        return "";
    }
}