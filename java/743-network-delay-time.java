class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, -1);

        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(new int[] {time[1], time[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] {k, 0});
        while (!pq.isEmpty()) {
            int from = pq.peek()[0];
            int time = pq.poll()[1];
            if (minTime[from] != -1) {
                continue;
            }
            minTime[from] = time;

            for (int[] next : graph[from]) {
                pq.add(new int[] {next[0], next[1] + time});
            }
        }

        int maxTime = -1;
        for (int i = 1; i <= n; ++i) {
            if (minTime[i] == -1) {
                return -1;
            }
            maxTime = Math.max(maxTime, minTime[i]);
        }
        return maxTime;
    }
}