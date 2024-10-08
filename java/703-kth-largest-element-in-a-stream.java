class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            heapify(num);
    }

    public int add(int val) {
        heapify(val);
        return minHeap.peek();
    }

    private void heapify(int num) {
        minHeap.offer(num);
        if (minHeap.size() > k)
            minHeap.poll();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */