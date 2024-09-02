/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n = findLen(head);
        if (n == 0 || k == 0 || k % n == 0)
           return head;

        k %= n;
        k = n - k + 1;
        ListNode tempHead = head;
        ListNode start = null;
        ListNode prev = null;
        ListNode end = null;
        while (tempHead != null) {
            end = tempHead;
            if (k-- > 0) {
                prev = start;
                start = tempHead;
            }
            tempHead = tempHead.next;
        }
        end.next = head;
        if (prev != null)
           prev.next = null;
        return start;
    }
    private int findLen(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            ++len;
        }
        return len;
    }
}