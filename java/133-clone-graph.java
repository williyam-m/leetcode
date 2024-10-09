/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
           return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node start = new Node(1);
        map.put(node, start);
        while (!queue.isEmpty()) {
            Node g = queue.poll();
            if (g.neighbors == null)
               continue;

            for (Node n : g.neighbors) {
                if (!map.containsKey(n)) {
                    queue.add(n);
                    map.put(n, new Node(n.val));
                }
                map.get(g).neighbors.add(map.get(n));
            }
        }
        return start;
    }
}