class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int index = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; ++i) {
            if (minValue > capacity[i] && capacity[i] >= itemSize) {
                minValue = capacity[i];
                index = i;
            }
        }
        return index;
    }
}