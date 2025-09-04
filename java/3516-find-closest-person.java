class Solution {
    public int findClosest(int x, int y, int z) {
        int x1 = Math.abs(z - x);
        int y1 = Math.abs(y - z);
        if (x1 == y1) {
            return 0;
        }
        return x1 < y1 ? 1 : 2;
    }
}