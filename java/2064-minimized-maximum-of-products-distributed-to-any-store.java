class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 0;
        int high = Arrays.stream(quantities).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            if (solve(n, quantities, mid)) {
               high = mid;
            }
            else
               low = mid + 1;
        }
        return low;
    }
    private boolean solve(int n, int[] quantities, int item) {
        if (item == 0)
           return false;
        int store = 0;
        for (int q : quantities) {
            store += (q - 1) / item + 1;
            if (store > n)
               return false;
        }
        return true;
    }
}