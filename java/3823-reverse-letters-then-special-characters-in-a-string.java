class Solution {
    public String reverseByType(String s) {
        char[] result = s.toCharArray();
        reverse(result, true);
        reverse(result, false);
        return new String(result);
    }
    private void reverse (char[] result, boolean letter) {
        int l = 0;
        int r = result.length - 1;
        while (l < r) {
            while (l < r && ( 
                (letter && Character.isLetter(result[l])) || 
                (!letter && !Character.isLetter(result[l])) )) {
                ++l;
            }
            while (l < r && ( 
                (letter && Character.isLetter(result[r])) || 
                (!letter && !Character.isLetter(result[r])) )) {
                --r;
            }
            if (l < r) {
                char temp = result[r];
                result[r--] = result[l];
                result[l++] = temp;
            }
        }
    }
}