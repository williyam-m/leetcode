class Solution {
    private String tens[] = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private String belowTwenty[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    public String numberToWords(int num) {
        return num == 0 ? "Zero" : helper(num);
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 20)
            sb.append(belowTwenty[num]);
        else if (num < 100)
            sb.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        else if (num < 1000000)
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        else if (num < 1000000000)
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        else
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));

        return sb.toString().trim();
    }
}