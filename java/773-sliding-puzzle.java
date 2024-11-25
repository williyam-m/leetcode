class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = 2;
        int n = 3;
        String start = "";
        String goal = "123450";
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                start += (char) ('0' + board[i][j]);
        
        if (goal.equals(start))
            return 0;

        Queue<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        q.add(start);
        set.add(start);

        for (int step = 1; !q.isEmpty(); ++step) {
            for (int size = q.size(); size > 0; --size) {
                String s = q.poll();
                int zeroIndex = s.indexOf('0');
                int i = zeroIndex / n;
                int j = zeroIndex % n;
                
                for (int d[] : dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x < 0 || y < 0 || x == m || y == n)
                        continue;
                    int swapIndex = x * n + y;
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(zeroIndex, s.charAt(swapIndex));
                    sb.setCharAt(swapIndex, s.charAt(zeroIndex));
                    String t = sb.toString();
                    if (t.equals(goal))
                        return step;
                    if (!set.contains(t)) {
                        q.add(t);
                        set.add(t);
                    }
                }
            }
        }
        return -1;
    }
}