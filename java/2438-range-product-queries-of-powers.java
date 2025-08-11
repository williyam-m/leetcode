class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = getPowersForN(n);
        int[] answer = new int[queries.length];
        int mod = 1000000007;

        for (int i = 0; i < queries.length; ++i) {
            long power = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; ++j) {
                power = (power * powers.get(j)) % mod;
            }
            answer[i] = (int) power;
        }
        return answer;
    }
    private List<Integer> getPowersForN(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 31; ++i) {
            if (((n >> i) & 1) == 1) {
                list.add(1 << i);
            }
        }
        return list;
    }
}