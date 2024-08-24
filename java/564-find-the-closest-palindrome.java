class Solution {
    public String nearestPalindromic(String n) {
        long[] ans = findPalindromic(n);
        return Long.parseLong(n) - ans[0] <= ans[1] - Long.parseLong(n) ? String.valueOf(ans[0])
                : String.valueOf(ans[1]);
    }

    private long[] findPalindromic(String s) {
        long num = Long.parseLong(s);
        int n = s.length();
        long[] ans = new long[2];
        String half = s.substring(0, (n + 1) / 2);
        String revHalf = new StringBuilder(half.substring(0, n / 2)).reverse().toString();

        long candidate = Long.parseLong(half + revHalf);

        if (candidate < num)
            ans[0] = candidate;
        else {
            String prevHalf = String.valueOf(Long.parseLong(half) - 1);
            String revPrevHalf = new StringBuilder(prevHalf.substring(0, Math.min(prevHalf.length(), n / 2))).reverse()
                    .toString();
            if (n % 2 == 0 && prevHalf.equals("0"))
                ans[0] = 9;
            else if (n % 2 == 0 && prevHalf.equals("9"))
                ans[0] = Long.parseLong(prevHalf + "9" + revPrevHalf);
            else
                ans[0] = Long.parseLong(prevHalf + revPrevHalf);
        }

        if (candidate > num)
            ans[1] = candidate;
        else {
            String prevHalf = String.valueOf(Long.parseLong(half) + 1);
            String revPrevHalf = new StringBuilder(prevHalf.substring(0, n / 2)).reverse().toString();
            ans[1] = Long.parseLong(prevHalf + revPrevHalf);
        }

        return ans;
    }
}