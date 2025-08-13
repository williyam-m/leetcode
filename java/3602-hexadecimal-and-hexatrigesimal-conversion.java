class Solution {
    public String concatHex36(int n) {
        return convert(n * n, 16) + convert(n * n * n, 36);
    }
    private String convert (int n, int base) {
        String num = "";
        while (n > 0) {
            num = convertHexRep(n % base) + num;
            n /= base;
        }
        return num;
    }
    private char convertHexRep (int n) {
        if (n <= 9) {
            return Character.forDigit(n, 10);
        }
        return (char) ('A' + (n - 10));
    }
}