class Solution {
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) {
            --W;
        }
        return new int[] {area / W, W}; // L = area / W;
        /*
        int L = area;
        int W = 1;
        int minDiffL = L;
        int minDiffW = W;
        int minDiff = L - W;
        while (L >= W) {
            if (L * W == area && minDiff > L - W) {
                minDiffL = L;
                minDiffW = W;
                minDiff = L - W;
            }
            ++W;
            L = area / W;
        }
        return new int[] {minDiffL, minDiffW};
        */
    }
}