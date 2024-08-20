class Solution {
    public boolean stoneGame(int[] piles) {
        int alice = 0;
        int bob = 0;
        int l = 0, r = piles.length - 1;
        while (l < r) {
            if (piles[l] == piles[r]) {
                ++l;
                --r;
            } else {
                if (piles[l] > piles[r])
                    alice = piles[l++];
                else
                    alice = piles[r--];

                if (piles[l] > piles[r])
                    bob = piles[l++];
                else
                    bob = piles[r--];
            }
        }
        if (alice > bob)
            return true;
        return false;
    }
}