class Solution {
    public boolean canReach(int[] start, int[] target) {
        // 1 (odd) move : same color
        // 2 (even) move : diff color
        // black color : same i % 2, j % 2
        // white color : diff i % 2, j % 2
        return (start[0] % 2 == start[1] % 2) == (target[0] % 2 == target[1] % 2);
    }
}