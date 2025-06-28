class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; ++i) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (x, y) -> y[0] - x[0]);
        pairs = Arrays.copyOf(pairs, k);
        Arrays.sort(pairs, (x, y) -> x[1] - y[1]);

        for (int i = 0; i < k; ++i) {
            ans[i] = pairs[i][0];
        }
        return ans;
        /*
        int[] ans = new int[k];
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            pairs.add(new Pair<>(nums[i], i));
        }
pairs.sort(Comparator.comparing((Pair<Integer, Integer> p) -> p.getKey()).reversed());
        pairs = new ArrayList<>(pairs.subList(0, k));
        pairs.sort(Comparator.comparing(Pair::getValue));

        for (int i = 0; i < k; ++i) {
            ans[i] = pairs.get(i).getKey();
        }
        return ans;
        */
    }
}