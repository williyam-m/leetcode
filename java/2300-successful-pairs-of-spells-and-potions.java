class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; ++i) {
            pairs[i] = m - binarySearch(potions, m, spells[i], success);
        }

        return pairs;
    }

    private int binarySearch(int[] potions, int m, int spell, long success) {
        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) potions[mid] * spell >= success)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}