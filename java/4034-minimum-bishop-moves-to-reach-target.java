class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        boolean isSourceWhite = (source[0] % 2 == 0) == (source[1] % 2 == 0);
        boolean isTargetWhite = (target[0] % 2 == 0) == (target[1] % 2 == 0);
        if (isSourceWhite != isTargetWhite) {
            return -1;
        }

        // diagonal
        if (Math.abs(source[0] - target[0]) == Math.abs(source[1] - target[1])) {
            return 1;
        }
        return 2;
    }
}