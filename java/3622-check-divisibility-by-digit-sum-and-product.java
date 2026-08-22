class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int num = n;
        while (num > 0) {
            sum += num % 10;
            product *= num % 10;
            num /= 10;
        }
        return n % (sum + product) == 0;
    }
    /*
    public boolean checkDivisibility(int n) {
        return n % (find(n, '+') + find(n, '*')) == 0;
    }
    private int find(int n, char opr) {
        int ans = opr == '+' ? 0 : 1;
        while (n > 0) {
            switch (opr) {
                case '+':
                    ans += n % 10;
                    break;
                case '*':
                    ans *= n % 10;
                    break;
            }
            n /= 10;
        }
        return ans;
    }
    */
}