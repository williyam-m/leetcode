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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = new ListNode(head.val - 1);
        ListNode temp = head;
        while (temp != null) {
            if (prev.val != temp.val) {
                prev.next = temp;
                prev = prev.next;
            }
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }
}