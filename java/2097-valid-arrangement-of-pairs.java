class Solution {
    public int[][] validArrangement(int[][] pairs) {
        List<int[]> ans = new ArrayList<>();
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.putIfAbsent(start, new ArrayDeque<>());
            graph.get(start).push(end);
            inDegree.merge(end, 1, Integer::sum);
            outDegree.merge(start, 1, Integer::sum);
        }

        int startNode = getStartNode(graph, inDegree, outDegree, pairs);
        euler(graph, startNode, ans);
        Collections.reverse(ans);
        return ans.stream().toArray(int[][] ::new);
    }
    private int getStartNode(Map<Integer, Deque<Integer>> graph, Map<Integer, Integer> inDegree, Map<Integer, Integer> outDegree, int[][] pairs) {
        for (int u : graph.keySet()) {
            if (outDegree.getOrDefault(u, 0) - inDegree.getOrDefault(u, 0) == 1)
                return u;
        }
        return pairs[0][0];
    }
    private void euler(Map<Integer, Deque<Integer>> graph, int u, List<int[]> ans) {
        Deque<Integer> stack = graph.get(u);
        while (stack != null && !stack.isEmpty()) {
            int v = stack.pop();
            euler(graph, v, ans);
            ans.add(new int[] {u, v});
        }
    }
}