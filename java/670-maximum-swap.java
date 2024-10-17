class Solution {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < str.length; ++i)
            index[str[i] - '0'] = i;

        for (int i = 0; i < str.length; ++i) {
            for (int j = 9; j > str[i] - '0'; --j) {
                if (index[j] > i) {
                    char temp = str[index[j]];
                    str[index[j]] = str[i];
                    str[i] = temp;
                    return Integer.parseInt(String.valueOf(str));
                }
            }
        }
        return num;
    }
    /*
     * public int maximumSwap(int num) {
     * StringBuilder sb = new StringBuilder(String.valueOf(num));
     * int max = Integer.parseInt(sb.toString());
     * for (int i = 0; i < sb.length(); ++i) {
     * for (int j = i + 1; j < sb.length(); ++j) {
     * StringBuilder sb1 = new StringBuilder(String.valueOf(num));
     * char temp = sb1.charAt(i);
     * sb1.setCharAt(i, sb1.charAt(j));
     * sb1.setCharAt(j, temp);
     * System.out.println(sb1);
     * max = Math.max(max, Integer.parseInt(sb1.toString()));
     * }
     * }
     * return max;
     * }
     */
}