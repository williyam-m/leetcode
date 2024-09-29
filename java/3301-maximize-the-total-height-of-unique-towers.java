class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Integer[] integerArray = Arrays.stream(maximumHeight)
                                       .boxed()
                                       .toArray(Integer[]::new);
        
        Arrays.sort(integerArray, Collections.reverseOrder());
        
        maximumHeight = Arrays.stream(integerArray)
                                  .mapToInt(Integer::intValue)
                                  .toArray();

        long sum = maximumHeight[0];
        for (int i = 1; i < maximumHeight.length; ++i) {
            if (maximumHeight[i - 1] <= maximumHeight[i]) {
                if (maximumHeight[i - 1] - 1 <= 0)
                    return -1;
                maximumHeight[i] = maximumHeight[i - 1] - 1;
            }
            sum += maximumHeight[i];
        }
        return sum;
    }
}