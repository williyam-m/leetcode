class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; ++i)
            prefix[i] = arr[i] ^ prefix[i - 1];
        
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            if (q[0] == 0)
               ans[i++] = prefix[q[1]];
            else
               ans[i++] = (prefix[q[0] - 1] ^  prefix[q[1]]);
        }
        
        return ans;
    }
}