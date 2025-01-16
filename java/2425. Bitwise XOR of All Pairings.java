class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor_n1 = 0;
        int xor_n2 = 0;
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < Math.max(n, m); ++i) {
            if (i < n)
               xor_n1 ^= nums1[i];
            if (i < m)
               xor_n2 ^= nums2[i];
        }
        return (xor_n1 * (m % 2)) ^ (xor_n2 * (n % 2));
    }
}