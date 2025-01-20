class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;
        int[] row = new int[m];
        int[] col = new int[n];

        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                map.put(mat[i][j], new Pair<>(i, j));
        }

        for (int i = 0; i < arr.length; ++i) {
            Pair<Integer, Integer> pair = map.get(arr[i]);
            if (++row[pair.getKey()] == n)
                return i;
            if (++col[pair.getValue()] == m)
                return i;
        }

        return -1;
    }
}