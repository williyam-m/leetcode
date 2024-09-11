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
    public int pairSum(ListNode head) {
        int n = findHalfLen(head);
        int[] twin = new int[n];
        int ans = 0;
        for (int i = 0; i < n * 2; ++i) {
            if (i >= n)
               ans = Math.max(ans, twin[(n * 2) - 1 - i] + head.val);
            else
               twin[i] = head.val;
            head = head.next;
        }
        return ans;
    }
    private int findHalfLen(ListNode head1) {
        int len = 0;
        ListNode slow = head1;
        ListNode fast = head1.next;
        while (fast != null && fast.next != null) {
            ++len;
            slow = slow.next;
            fast = fast.next.next;
        }
        return len + 1;
    }
}