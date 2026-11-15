class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        int even = 1;
        int odd = 0;
        int prefix = 0;
        long count = 0;
        for (int num : arr) {
            prefix += num;
            if (prefix % 2 == 0) {
                count += odd;
                ++even;
            }
            else {
                count += even;
                ++odd;
            }
            count %= MOD;
        }
        return (int) count;
    }
}