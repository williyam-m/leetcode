class SmallestInfiniteSet {
    int curr = 1;
    TreeSet<Integer> added = new TreeSet<>();

    public int popSmallest() {
        if (added.isEmpty())
            return curr++;
        int mn = added.first();
        added.remove(mn);
        return mn;
    }

    public void addBack(int num) {
        if (num < curr)
            added.add(num);
    }
}
/*class SmallestInfiniteSet {
    int k = 1000;
    int[] minHeap;
    public SmallestInfiniteSet() {
        minHeap = new int[k];
        for (int i = 1; i <= k; ++i)
            minHeap[i - 1] = i;
    }
    
    public int popSmallest() {
        for (int i = 1; i <= k; ++i) {
            if (minHeap[i - 1] != 0) {
                minHeap[i - 1] = 0;
                return i;
            }
        }
        return k;
    }
    
    public void addBack(int num) {
        minHeap[num - 1] = num;
    }
}*/

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */