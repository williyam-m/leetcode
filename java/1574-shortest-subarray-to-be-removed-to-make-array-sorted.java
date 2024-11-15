class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l < n - 1 && arr[l] <= arr[l + 1])
            ++l;
        while (r > 0 && arr[r] >= arr[r - 1])
            --r;

        int ans = Math.min(n - 1 - l, r);
        int i = l;
        int j = n - 1;

        while (i >= 0 && j >= r && j > i) {
            if (arr[i] <= arr[j])
               --j;
            else
               --i;
            ans = Math.min(ans, j - i);
        }

        return ans;
    }
}