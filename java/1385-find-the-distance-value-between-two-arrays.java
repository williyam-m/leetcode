class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int inValid = 0;
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    ++inValid;
                    break;
                }
            }
        }
        return arr1.length - inValid;
    }
}