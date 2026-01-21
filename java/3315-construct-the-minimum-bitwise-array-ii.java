class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); ++i) {
            result[i] = nums.get(i) == 2 ? -1 : nums.get(i) - getLeadingOneOfLastGroupOfOnes(nums.get(i));
        }
        return result;
    }
    private int getLeadingOneOfLastGroupOfOnes(int n) {
        int leadingOne = 1;
        while ((leadingOne & n) != 0) {
            leadingOne <<= 1;
        }
        return leadingOne >> 1;
    }
}