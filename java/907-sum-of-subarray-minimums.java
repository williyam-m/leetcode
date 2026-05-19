class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nextMin = new int[n];
        int[] prevMin = new int[n];
        Arrays.fill(nextMin, n);
        Arrays.fill(prevMin, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextMin[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                prevMin[i] = stack.peek();
            }
            stack.push(i);
        }
        int mod = 1_000_000_007;
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += (long) arr[i] * (i - prevMin[i]) * (nextMin[i] - i);
            sum %= mod;
        }
        return (int) sum;
    }
}