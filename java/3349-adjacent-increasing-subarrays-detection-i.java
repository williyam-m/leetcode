class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - (k + k); ++i) {
            if (isStrictlyIncreasing(nums.subList(i, i + k)) && isStrictlyIncreasing(nums.subList(i + k, i + (k + k)))) {
                return true;
            }
        }
        return false;
    }
    private boolean isStrictlyIncreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}