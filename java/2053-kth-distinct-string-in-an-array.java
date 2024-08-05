class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String a : arr)
            map.merge(a, 1, Integer::sum);

        for (String a : arr) {
            if (map.get(a) == 1) {
                --k;
                if (k == 0)
                    return a;
            }
        }
        return "";
    }
}