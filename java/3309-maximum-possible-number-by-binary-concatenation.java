class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i)
            str[i] = convertToBit(nums[i]);

        List<String> permutation = new ArrayList<>();
        permutate(permutation, 0, str);

        int max = 0;
        for (String s : permutation)
           max = Math.max(max, Integer.parseInt(s, 2));
        return max;
        
    }
    private String convertToBit(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
    private void permutate (List<String> permutation, int start, String[] str) {
        if (start == str.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (String s : str)
                sb.append(s);
            permutation.add(sb.toString());
        }

        for (int i = start; i < str.length; ++i) {
            swap(str, start, i);
            permutate(permutation, start + 1, str);
            swap(str, start, i);
        }
    }
    private void swap (String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    } 
}