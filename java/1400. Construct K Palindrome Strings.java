class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
           return false;
        int[] count = new int[26];
        for (char c : s.toCharArray())
           ++count[c - 'a'];
        
        int even = 0;
        int odd = 0;
        for (int n : count) {
            if (n == 0)
               continue;
            if (n % 2 == 0)
               ++even;
            else
               ++odd;
        }

        if (odd > k)
            return false;

        return true;
    }
}