class CustomStack {
    int[] stack;
    int top;
    int n;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = 0;
        n = maxSize;
    }
    
    public void push(int x) {
        if (top != n)
           stack[top++] = x;
    }
    
    public int pop() {
        if (top == 0)
           return -1;
        return stack[--top];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(top, k); ++i)
            stack[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */