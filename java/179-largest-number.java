class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsStr = new String[n];
        for (int i = 0; i < n; ++i) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : numsStr) {
            sb.append(s);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}