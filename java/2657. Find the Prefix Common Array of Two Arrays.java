class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int n = A.length;
        int[] C = new int[n];

        for (int i = 0; i < n; ++i) {
            if (!set.add(A[i]))
               ++count;
            if (!set.add(B[i]))
               ++count;
            C[i] = count;
        }
        return C;
    }
}