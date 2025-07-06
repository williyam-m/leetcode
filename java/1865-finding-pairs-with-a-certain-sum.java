class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> count = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        count.put(nums2[index], count.get(nums2[index]) - 1);
        if (count.get(nums2[index]) == 0) {
            count.remove(nums2[index]);
        }
        nums2[index] += val;
        count.put(nums2[index], count.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int sum = 0;
        for (int num : this.nums1) {
            sum += count.getOrDefault(tot - num, 0);
        }
        return sum;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */