/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root != null)
            connect(root.left, root.right);
        return root;
    }
    private void connect(Node root_l, Node root_r) {
        if (root_l == null || root_r == null)
            return ;
        
        root_l.next = root_r;
        connect(root_l.left, root_l.right);
        connect(root_l.right, root_r.left);
        connect(root_r.left, root_r.right);
    }
}