class Node {
    int val;
    int key;
    Node prev;
    Node next;
    Node(int key, int value, Node prev) {
        this.val = value;
        this.key = key;
        this.prev = prev;
    }
}
class LRUCache {
    int k;
    Map<Integer, Node> map;
    Node recent = new Node(-1, -1, null);
    Node head = recent;

    public LRUCache(int capacity) {
        k = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        Node curr = map.get(key);
        if (recent.key != key && curr.prev != null)
            makeRecent(curr);

        return curr.val;
    }
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            recent.next = new Node(key, value, recent);
            recent = recent.next;
            map.put(key, recent);
            
            if (k == 0) {
                map.remove(head.next.key);
                head.next.next.prev = head;
                head.next = head.next.next;
            } 
            else
                --k;

        } else {
            Node curr = map.get(key);
            curr.val = value;
            if (recent.key != key && curr.prev != null)
                makeRecent(curr);
        }
    }
    private void makeRecent(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        recent.next = curr;
        curr.prev = recent;
        recent = recent.next;
        recent.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */