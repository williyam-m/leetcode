class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        List<int[]>[] graph = new List[n];
        boolean[][] visited = new boolean[n][k + 2];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>(); 
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[] {to, price});
        }
        pq.add(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int from = pq.peek()[0];
            int curr_price = pq.peek()[1];
            int flight = pq.poll()[2];
            if (from == dst) {
                return curr_price;
            }
            if (flight > k) {
                continue;
            }
            if (visited[from][flight]) {
                continue;
            }
            visited[from][flight] = true;
            for (int[] next : graph[from]) {
                pq.add(new int[] {next[0], next[1] + curr_price, flight + 1});
            }
        }
        return -1;
    }
}