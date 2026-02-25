class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) -> {
            int aBitCount = Integer.bitCount(a);
            int bBitCount = Integer.bitCount(b);
            if (aBitCount == bBitCount) {
                return a - b;
            }
            return aBitCount - bBitCount;
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        /*
        List[] map = new ArrayList[32];
        for (int n : arr) {
            int bitCount = Integer.bitCount(n);
            if (map[bitCount] == null) {
                map[bitCount] = new ArrayList<>(); 
            }
            map[bitCount].add(n);
        }
        int i = 0;
        for (List<Integer> list : map) {
            if (list == null) {continue;}
            Collections.sort(list);
            for (Integer n : list) {
                arr[i++] = n;
            }
        }
        return arr;
        */
    }
}