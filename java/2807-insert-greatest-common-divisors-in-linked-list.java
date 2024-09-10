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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            int val = gcd(dummy.val, dummy.next.val);
            ListNode nextNode = dummy.next;
            dummy.next = new ListNode(val, nextNode);
            dummy = dummy.next.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}s