class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long ans = 0;
        Arrays.sort(happiness);
        int decrement = 0;
        for (int i = n - 1; i >= n - k; --i) {
            ans += Math.max(0, happiness[i] - decrement++);
        }
        return ans;
        /*
        long ans = 0;
        Arrays.sort(happiness);
        int n = happiness.length;
        for (int i = n - 1; i >= (n - k); --i) {
            int currentChildHappiness = happiness[i] - (n - i - 1);
            if (currentChildHappiness <= 0) {
                break;
            }
            ans += currentChildHappiness;
        }
        return ans;
        */
    }
}