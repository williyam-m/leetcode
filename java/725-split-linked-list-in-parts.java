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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = findLinkedListLen(head);
        ListNode[] ans = new ListNode[k];
        int part = n / k;
        int extra = n % k;

        ListNode prev = null;
        for (int i = 0; i < k; ++i) {
            if (head == null) {
                ans[i] = null;
                continue;
            }
            ans[i] = head;
            int len = 0;
            while (len++ < part) {
                prev = head;
                head = head.next;
            }
            if (extra-- > 0) {
                prev = head;
                head = head.next;
            }
            prev.next = null;
        }
        return ans;
    }

    private int findLinkedListLen(ListNode head1) {
        int len = 0;
        while (head1 != null) {
            ++len;
            head1 = head1.next;
        }
        return len;
    }
}