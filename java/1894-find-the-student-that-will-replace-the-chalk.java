class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk)
            sum += c;
        k = (int)((long)k % sum);
        if (k == 0)
           return 0;
        
        for (int i = 0; i < chalk.length; ++i){
            int c = chalk[i];
            if (k < c)
               return i;
            k -= c;
        }
        return 0;
    }
}