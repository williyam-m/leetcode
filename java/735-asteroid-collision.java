class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0
                    && Math.abs(stack.peek()) < Math.abs(asteroid)) {
                stack.pop();
            }
            if (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0) && stack.peek() + asteroid == 0) {
                stack.pop();
                continue;
            }
            if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0)
                stack.push(asteroid);
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        for (int s : stack)
            ans[i++] = s;
        return ans;
    }
}