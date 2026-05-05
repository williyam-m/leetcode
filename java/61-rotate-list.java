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
        int n = findSize(head);
        if (n == 0 || k % n == 0) {
            return head;
        }
        k %= n;
        n -= k;

        ListNode cacheHead = head;
        ListNode dummy = new ListNode(0);
        while (head != null) {
            if (n-- == 1) {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
                dummy.next = head;
            }
            if (head.next == null) {
                head.next = cacheHead;
                break;
            }
            head = head.next;
        } 

        return dummy.next;
    }
    private int findSize(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}