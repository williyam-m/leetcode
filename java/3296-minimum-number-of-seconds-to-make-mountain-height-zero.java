class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int workerTime : workerTimes)
            minHeap.offer(new long[] { workerTime, workerTime, 2 });

        long currTime = 0;
        while (mountainHeight-- > 0) {
            currTime = minHeap.peek()[0];
            long time = minHeap.peek()[1];
            long count = minHeap.poll()[2];
            minHeap.offer(new long[] { currTime + time * count, time, ++count });
        }
        return currTime;
    }
}