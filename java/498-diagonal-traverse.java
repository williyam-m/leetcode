class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<Integer>());
                }
                map.get(i + j).add(mat[i][j]);
            }
        }

        int[] ans = new int[n * m];
        int prevIndex = 0;
        for (Integer key : map.keySet()) {
            if (key % 2 == 0) {
                Collections.reverse(map.get(key));
            }
            int[] currArray = convertIntegerListToArray(map.get(key));
            System.arraycopy(currArray, 0, ans, prevIndex, currArray.length);
            prevIndex += currArray.length;
        }
        return ans;
    }
    public int[] convertIntegerListToArray(ArrayList<Integer>list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            array[i] = list.get(i);
        }
        return array;
    }
}