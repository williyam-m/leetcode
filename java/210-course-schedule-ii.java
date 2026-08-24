class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int[] prerequisite : prerequisites) {
            ++inDegree[prerequisite[0]];
            adjList[prerequisite[1]].add(prerequisite[0]);
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }


        int[] order = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            order[i++] = q.peek(); 
            for (int adj : adjList[q.poll()]) {
                if (--inDegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }
        return i == numCourses ? order : new int[] {};
    }
}