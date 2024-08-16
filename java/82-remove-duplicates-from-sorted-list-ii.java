/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        ListNode prev = null;

        while (head != null) {
            if ((prev == null || prev.val != head.val) && (head.next == null || head.val != head.next.val)) {
                dummy.next = head;
                dummy = dummy.next;
            }
            prev = head;
            head = head.next;
        }
        dummy.next = null;

        return ans.next;
    }
}