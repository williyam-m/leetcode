class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            set.add(nums.get(i));
            for (int j = i + 1; j < n; ++j) {
                set.add(nums.get(j));
                sum += set.size() * set.size();
            }
        }
        return sum + n;
    }
}