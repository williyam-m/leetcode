class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int currPrefix = 0;
        int currSuffix = 0;
        currPrefix = boxes.charAt(0) == '1' ? 1 : 0;
        currSuffix = boxes.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = 1; i < n; ++i) {
            prefix[i] += (prefix[i - 1] + currPrefix);
            suffix[n - 1 - i] += (suffix[n - 1 - i + 1] + currSuffix);
            if (boxes.charAt(i) == '1')
                ++currPrefix;
            if (boxes.charAt(n - 1 - i) == '1')
                ++currSuffix;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i)
            ans[i] = prefix[i] + suffix[i];
        
        return ans;
    }
}