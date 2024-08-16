class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int min = 10000;
        int max = -10000;
        for (List<Integer> array : arrays) {
            ans = Math.max(ans, Math.max(max - array.get(0), array.get(array.size() - 1) - min));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }
        return ans;
        
        /*
         * int[][] min = new int[2][2];
         * Arrays.fill(min[0], Integer.MAX_VALUE);
         * Arrays.fill(min[1], Integer.MAX_VALUE);
         * int[][] max = new int[2][2];
         * Arrays.fill(max[0], Integer.MIN_VALUE);
         * Arrays.fill(max[1], Integer.MIN_VALUE);
         * for (int i = 0; i < arrays.size(); ++i) {
         * int n = arrays.get(i).size();
         * if (arrays.get(i).get(0) < min[0][0]) {
         * min[1][0] = min[0][0];
         * min[1][1] = min[0][1];
         * min[0][0] = arrays.get(i).get(0);
         * min[0][1] = i;
         * }
         * else if (arrays.get(i).get(0) < min[1][0]) {
         * min[1][0] = arrays.get(i).get(0);
         * min[1][1] = i;
         * }
         * 
         * if (arrays.get(i).get(n - 1) > max[0][0]) {
         * max[1][0] = max[0][0];
         * max[1][1] = max[0][1];
         * max[0][0] = arrays.get(i).get(n - 1);
         * max[0][1] = i;
         * }
         * else if (arrays.get(i).get(n - 1) > max[1][0]) {
         * max[1][0] = arrays.get(i).get(n - 1);
         * max[1][1] = i;
         * }
         * }
         * if (min[0][1] != max[0][1])
         * return max[0][0] - min[0][0];
         * return Math.max(max[1][0] - min[0][0], max[0][0] - min[1][0]);
         */
    }
}