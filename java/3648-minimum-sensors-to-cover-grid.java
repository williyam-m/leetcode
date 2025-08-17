class Solution {
    public int minSensors(int n, int m, int k) {
        int s = 2 * k + 1;
        return ((n + s - 1) / s) * ((m + s - 1) / s);
    }
}