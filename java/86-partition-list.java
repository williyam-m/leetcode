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
    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode(0);
        ListNode ans = node;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                node.next = new ListNode(temp.val);
                node = node.next;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.val >= x) {
                node.next = new ListNode(temp.val);
                node = node.next;
            }
            temp = temp.next;
        }

        return ans.next;
    }
}