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
        int i = 1;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && left > i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode res[] = reverse(curr, right - left + 1);
        if (left == 1) {
            head = res[0];
            if (res[1] == null)
                return res[0];
        }
        else
            prev.next = res[0];
        curr.next = res[1];
        
        return head;
    }
    private ListNode[] reverse (ListNode node, int len) {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null && len-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[] {prev, curr};
    } 
}