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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode dummyOdd = head;
        ListNode startEven = head.next;
        ListNode dummyEven = head.next;
        while (dummyOdd != null && dummyEven != null && dummyOdd.next != null && dummyEven.next != null) {
            dummyOdd.next = dummyOdd.next.next;
            dummyOdd = dummyOdd.next;
            dummyEven.next = dummyEven.next.next;
            dummyEven = dummyEven.next;
        }
        dummyOdd.next = startEven;

        return head;
    }
}