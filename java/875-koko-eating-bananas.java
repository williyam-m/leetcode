class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles)
            max = Math.max(max, pile);

        int l = 1;
        int r = max;
        while (l < r) {
            int m = (l + r) / 2;
            if (canEat(piles, m) <= h)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private int canEat(int[] piles, int k) {
        int ans = 0;
        for (int pile : piles) {
            if (pile % k != 0)
                ++ans;
            ans += (pile / k);
        }
        return ans;
    }
}