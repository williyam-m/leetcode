/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            oldToNew.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            oldToNew.get(temp).next = oldToNew.get(temp.next);
            oldToNew.get(temp).random = oldToNew.get(temp.random);
            temp = temp.next;
        }
        return oldToNew.get(head);
    }
}