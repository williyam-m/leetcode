class Solution {
    public int minimumDistance(int[] nums) {
        int[] prevIndex = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                prevIndex[i] = map.get(nums[i]);
            }
            else {
                prevIndex[i] = -1;
            }
            map.put(nums[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            //secoundIndex : prevIndex[i];
            //firstIndex : prevIndex[prevIndex[i]];
            if (prevIndex[i] != -1 && prevIndex[prevIndex[i]] != -1) {
                ans = Math.min(ans, i - prevIndex[prevIndex[i]]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans * 2; 

        /*
        List<int[]> numsWithIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            numsWithIndex.add(new int[] {i, nums[i]});
        }
        Collections.sort(numsWithIndex, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (numsWithIndex.get(i)[1] == numsWithIndex.get(i + 1)[1] && numsWithIndex.get(i)[1] == numsWithIndex.get(i + 2)[1]) {
                ans = Math.min(ans, numsWithIndex.get(i + 2)[0] - numsWithIndex.get(i)[0]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans * 2;
        */
    }
}