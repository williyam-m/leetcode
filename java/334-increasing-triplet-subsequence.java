class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int secound = Integer.MAX_VALUE;
        for (int num : nums) {
            if (first >= num)
                first = num;
            else if (secound >= num)
                secound = num;
            else
                return true;
        }
        return false;
    }
}