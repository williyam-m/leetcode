class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }
        }
        int n = 0;
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) == 1) {
                map.put(nums2[i], 2);
                ++n;
            }
        }
        int[] ans = new int[n];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                ans[--n] = entry.getKey();
            }
        }
        return ans;
    }
}