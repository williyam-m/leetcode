class MyCircularDeque {
    int[] queue;
    int p1;
    int p2;
    int k;
    public MyCircularDeque(int k) {
        queue = new int[k * 2];
        p1 = k - 1;
        p2 = k;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull())
           return false;
        queue[p1--] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull())
           return false;
        queue[p2++] = value;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty())
           return false;
        p1++;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty())
           return false;
        p2--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty())
           return -1;
        return queue[p1 + 1];
    }
    
    public int getRear() {
        if (isEmpty())
           return -1;
        return queue[p2 - 1];
    }
    
    public boolean isEmpty() {
        return p2 - p1 == 1;
    }
    
    public boolean isFull() {
        return (p2 - p1 - 1) == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */