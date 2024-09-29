class Node {
    int count;
    Set<String> keys = new HashSet<>();
    Node prev = null;
    Node next = null;

    Node(int count) {
        this.count = count;
    }
}

class AllOne {
    Map<String, Node> map = new HashMap<>();
    Node head = new Node(0);
    Node tail = new Node(0);

    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key))
            increment(key);
        else
            add(key);
    }

    private void increment(String key) {
        Node node = map.get(key);
        node.keys.remove(key);

        if (node.next == tail || node.next.count > node.count + 1)
            insert(node, new Node(node.count + 1));

        node.next.keys.add(key);
        map.put(key, node.next);

        if (node.keys.isEmpty())
            remove(node);
    }

    private void add(String key) {
        if (head.next.count != 1)
            insert(head, new Node(1));

        head.next.keys.add(key);
        map.put(key, head.next);
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.keys.remove(key);

        if (node.count > 1) {
            if (node.prev == head || node.prev.count != node.count - 1)
                insert(node.prev, new Node(node.count - 1));
            node.prev.keys.add(key);
            map.put(key, node.prev);
        } else
            map.remove(key);

        if (node.keys.isEmpty())
            remove(node);
    }

    private void insert(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */