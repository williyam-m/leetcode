class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue mapHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int gift : gifts) {
            mapHeap.offer(gift);
        }

        while (k-- > 0) {
            int max = (int) Math.sqrt((int) mapHeap.poll());
            mapHeap.offer(max);
        }
        while (!mapHeap.isEmpty()) {
            ans += (int) mapHeap.poll();
        }
        return ans;
    }
}