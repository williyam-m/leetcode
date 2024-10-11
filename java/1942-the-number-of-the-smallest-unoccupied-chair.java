class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] withIndex = new int[n][3];

        for (int i = 0; i < n; ++i) {
            withIndex[i] = new int[] { times[i][0], times[i][1], i };
        }

        Arrays.sort(withIndex, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> chair = new PriorityQueue<>();
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] t : withIndex) {
            while (!occupied.isEmpty() && occupied.peek()[0] <= t[0]) {
                chair.add(occupied.poll()[1]);
            }

            if (t[2] == targetFriend) {
                return chair.isEmpty() ? i : chair.peek();
            }

            if (chair.isEmpty())
                occupied.add(new int[] { t[1], i++ });
            else
                occupied.add(new int[] { t[1], chair.poll() });
        }
        return -1;
    }
}