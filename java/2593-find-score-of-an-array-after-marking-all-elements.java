class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        TreeSet<Pair<Integer, Integer>> numWithIndex = new TreeSet<>((a, b)
         -> a.getKey().equals(b.getKey())
        ? a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));

        for (int i = 0; i < n; ++i) {
            numWithIndex.add(new Pair<>(nums[i], i));
        }

        boolean[] seen = new boolean[n];
        for (Pair<Integer, Integer> pair : numWithIndex) {
            int i = pair.getValue();
            if (seen[i])
               continue;
            if (i > 0)
               seen[i - 1] = true;
            if (i < n - 1)
               seen[i + 1] = true;
            ans += nums[i];
            seen[i] = true;
        }
        return ans;
    }
}