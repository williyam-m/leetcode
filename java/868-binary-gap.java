class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int prev = -1;
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) == 1) {
                if (prev >= 0) {
                    maxDistance = Math.max(maxDistance, i - prev);
                }
                prev = i;
            }
        }
        return maxDistance;
        /*
        int maxDistance = 0;
        int currDistance = 1;
        boolean isEdgeOne = true;
        while (n > 0) {
            if (isEdgeOne && ((n & 1) == 1)) {
                isEdgeOne = false;
                currDistance = 1;
            }
            else if ((n & 1) == 1) {
                maxDistance = Math.max(maxDistance, currDistance);
                currDistance = 1;
            }
            else {
                ++currDistance;
            }
            n >>= 1;
        }
        return maxDistance;
        */
    }
}