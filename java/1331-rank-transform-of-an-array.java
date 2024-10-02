class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Map<Integer, Integer> mapRank = new HashMap<>();
        int rank = 0;
        Arrays.sort(sortedArr);
        for (int n : sortedArr) {
            if (!mapRank.containsKey(n)) {
                mapRank.put(n, ++rank);
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = mapRank.get(arr[i]);
        }
        return arr;
    }
}