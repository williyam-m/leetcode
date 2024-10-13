class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        record T(int i, int j, int num) {
        }
        ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Queue<T> minHeap = new PriorityQueue<>((a, b) -> (a.num - b.num));
        int k = nums.size();

        for (int i = 0; i < k; ++i) {
            int num = nums.get(i).get(0);
            minHeap.offer(new T(i, 0, num));
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int minRange = min;
        int maxRange = max;

        while (k == minHeap.size()) {
            System.out.println(minHeap.peek().i);
            int i = minHeap.peek().i;
            int j = minHeap.poll().j;
            if (j + 1 < nums.get(i).size()) {
                int num = nums.get(i).get(j + 1);
                minHeap.offer(new T(i, j + 1, num));
                max = Math.max(max, num);
                min = minHeap.peek().num;
            }

            if (max - min < maxRange - minRange) {
                minRange = min;
                maxRange = max;
            }
        }

        return new int[] { minRange, maxRange };
    }
}