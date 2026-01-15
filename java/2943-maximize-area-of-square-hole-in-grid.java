class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(findMaxIncCount(hBars), findMaxIncCount(vBars));
        return (int) Math.pow(side, 2);
    }
    public int findMaxIncCount(int[] array) {
        int maxCount = 1;
        int currCount = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == array[i - 1] + 1) {
                ++currCount;
                continue;
            }
            maxCount = Math.max(maxCount, currCount);
            currCount = 1;
        }
        return Math.max(maxCount, currCount) + 1;
    }
}