class Solution {
    private int num = 0;
    private int den = 1;
    private String expression;
    private int n;
    private int i = 0;

    public String fractionAddition(String expression) {
        this.expression = expression;
        this.n = expression.length();
        while (i < n) {
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i++) == '-' ? -1 : 1;
            }
            int a = findNum();
            a *= sign;
            ++i;
            int b = findNum();

            num = (num * b) + (den * a);
            den *= b;

            int gcd = Math.abs(gcd(num, den));
            num /= gcd;
            den /= gcd;
        }

        return "" + num + "/" + den;
    }
    private int gcd(int num, int den) {
        return den == 0 ? num : gcd(den, num % den);
    }

    private int findNum() {
        int num = 0;
        while (i < n && Character.isDigit(expression.charAt(i))) {
            num = num * 10 + (expression.charAt(i++) - '0');
        }
        return num;
    }
}