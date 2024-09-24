class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : arr1) {
            while (a != 0) {
                set.add(a);
                a /= 10;
            }
        }

        for (int a : arr2) {
            while (a != 0) {
                if (set.contains(a)) {
                    ans = Math.max(ans, String.valueOf(a).length());
                }
                a /= 10;
            }
        }
        return ans;
    }
}