class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] classe : classes) {
            maxHeap.offer(new double[] {getExtraPassRatio(classe[0], classe[1]), classe[0], classe[1]});
        }
        while (extraStudents-- > 0) {
            double[] curr = maxHeap.poll();
            maxHeap.offer(new double[] {getExtraPassRatio(curr[1] + 1, curr[2] + 1), curr[1] + 1, curr[2] + 1});
        }

        double ans = 0;

        for (double[] classe : maxHeap) {
            ans += classe[1] / classe[2];
        }
        return ans / (double) classes.length;
    }
    private double getExtraPassRatio(double pass, double total) {
        return ((pass + 1) / (total + 1)) - ((pass) / (total));
    }
}