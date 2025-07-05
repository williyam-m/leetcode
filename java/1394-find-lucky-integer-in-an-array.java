class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = arr.length - 1; i > 0; --i) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] == count) {
                    return count;
                }
                count = 1;
            }
            else {
                ++count;
            }
        }
        if (arr[0] == count) {
            return count;
        }
        return -1;
    }
}