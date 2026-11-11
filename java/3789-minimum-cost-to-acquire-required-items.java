class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long splitTotal = Long.MAX_VALUE;
        if (need1 != need2) {
            splitTotal = (long) costBoth * Math.min(need1, need2);
            if (need1 > need2) {
                splitTotal += (long) cost1 * (need1 - need2);
            }
            else {
                splitTotal += (long) cost2 * (need2 - need1);
            }
        }
        return Math.min((long) costBoth * Math.max(need1, need2), 
                Math.min(splitTotal, (long) cost1 * need1 + (long) cost2 * need2));
    }
}