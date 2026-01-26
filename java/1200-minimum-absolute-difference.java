class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minAbsDiff = Integer.MAX_VALUE;
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; ++i) {
            int currAbsDiff = Math.abs(arr[i + 1] - arr[i]);
            if (currAbsDiff > minAbsDiff) {
                continue;
            }
            else if (currAbsDiff < minAbsDiff) {
                pairs = new ArrayList<>();
                minAbsDiff = currAbsDiff;
            }
            pairs.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
        }
        return pairs;
    }
}