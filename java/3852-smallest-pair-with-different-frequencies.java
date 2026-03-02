class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] count = new int[101];
        for (int n : nums)  {
            ++count[n];
        }
        int i = -1;
        for (int j = 0; j <= 100; ++j) {
            if (count[j] == 0) {
                continue;
            }
            if (i == -1) {
                i = j;
            }
            else if (count[i] != count[j]) {
                return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}