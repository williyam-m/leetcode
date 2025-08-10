class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortNum(n);
        for (int i = 0; i < 31; ++i) {
            if (sortNum(1 << i).equals(target)) {
                return true;
            }
        }
        return false;
    }
    private String sortNum (int n) {
        char[] c = String.valueOf(n).toCharArray();
        Arrays.sort(c);
        return new String(c); 
    }
}