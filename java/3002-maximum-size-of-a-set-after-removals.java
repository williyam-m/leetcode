class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2)
            set2.add(num);

        int common = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                ++common;
            }
        }
        int s1 = Math.min(set1.size() - common, n / 2);
        int s2 = Math.min(set2.size() - common, n / 2);

        return Math.min(n, s1 + s2 + common);
    }
}