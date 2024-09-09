class Solution {
    public String convertDateToBinary(String date) {
        return convertToBinary(date.substring(0, 4)) + '-' + convertToBinary(date.substring(5, 7)) + '-'
                + convertToBinary(date.substring(8, 10));
    }

    private String convertToBinary(String s) {
        int n = Integer.parseInt(s);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}