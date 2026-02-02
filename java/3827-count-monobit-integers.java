class Solution {
    public int countMonobit(int n) {
        int count = 1;
        long curr = 1;
        while (curr <= n) {
            ++count;
            curr = (curr << 1) | 1; //2x + 1
        }
        return count;
    }
}