class Solution {
    public int findComplement(int num) {
        for (long i = 1; i <= num; i <<= 1)
            num ^= i;
        return num;
    }
    /*
     * public int findComplement(int num) {
     * char[] bin = convertToBinary(num);
     * char[] binComplement = complement(bin);
     * return convertToDecimal(binComplement);
     * }
     * private int convertToDecimal(char[] binComplement) {
     * int ans = 0;
     * int n = binComplement.length;
     * for (int i = 0; i < n; ++i) {
     * if (binComplement[n - i - 1] == '1')
     * ans += Math.pow(2, i);
     * }
     * return ans;
     * }
     * private char[] convertToBinary(int num) {
     * String s = "";
     * while (num != 0) {
     * s = (num % 2) + s;
     * num /= 2;
     * }
     * return s.toCharArray();
     * }
     * private char[] complement(char[] bin) {
     * for (int i = 0; i < bin.length; ++i) {
     * if (bin[i] == '1')
     * bin[i] = '0';
     * else
     * bin[i] = '1';
     * }
     * return bin;
     * }
     */
}