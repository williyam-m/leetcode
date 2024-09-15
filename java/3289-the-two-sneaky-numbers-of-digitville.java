class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] count = new int[nums.length];
        int index = 0;
        int[] ans = new int[2];
        for (int n : nums) {
            if (index == 2)
                break;
            if (++count[n] > 1)
                ans[index++] = n;
        }
        return ans;
    }
}