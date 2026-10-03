class Solution {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        while (i < n) {
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int key = it.next();
                ans[i++] = key;
                if (map.get(key) == 1) {
                    it.remove();
                }
                else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        return ans;
    }
}