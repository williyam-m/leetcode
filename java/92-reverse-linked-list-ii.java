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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;

        for (int i = 1; i < left; ++i) {
            prevNode = prevNode.next;
        }
        ListNode currNode = prevNode.next;

        for (int i = 1; i < right - left + 1; ++i) {
            ListNode nextNode = currNode.next;
            currNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }
        return dummy.next;
    }
}