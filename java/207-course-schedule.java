class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            ++inDegree[pre[0]];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int i = queue.pop();
            ++count;
            for (Integer next : adj[i]) {
                if (--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return numCourses == count;
    }
}