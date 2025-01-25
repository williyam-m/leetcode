class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortArr = new int[n];
        for (int i = 0; i < n; ++i)
            sortArr[i] = nums[i];
        Arrays.sort(sortArr);

        Map<Integer, Integer> groupNum = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupMember = new HashMap<>();
        int groupKey = 0;

        groupNum.put(sortArr[0], groupKey);
        groupMember.put(groupKey, new LinkedList<Integer>(Arrays.asList(sortArr[0])));

        for (int i = 1; i < n; ++i) {
            if (Math.abs(sortArr[i] - sortArr[i - 1]) > limit)
               ++groupKey;
            groupNum.put(sortArr[i], groupKey);

            if (!groupMember.containsKey(groupKey))
               groupMember.put(groupKey, new LinkedList<Integer>());
            groupMember.get(groupKey).add(sortArr[i]);
        } 

        for (int i = 0; i < n; ++i) {
            int groupNumber = groupNum.get(nums[i]);
            nums[i] = groupMember.get(groupNumber).pop();
        }

        return nums;
    }
}