class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[n + 1];
        int[] C = new int[n];
        int currCount = 0;
        for (int i = 0; i < n; ++i) {
            if (++count[A[i]] == 2) {
                ++currCount;
            }
            if (++count[B[i]] == 2) {
                ++currCount;
            }
            C[i] = currCount;
        }
        return C;
    }
}