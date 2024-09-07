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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private boolean isPresent = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        dfs(head, root);
        return isPresent;
    }

    private void dfs(ListNode head, TreeNode root) {
        if (root == null || isPresent)
            return;
        if (root.val == head.val)
            check(root, head);
        dfs(head, root.left);
        dfs(head, root.right);
    }

    private void check(TreeNode root1, ListNode head1) {
        if (head1 == null)
            isPresent = true;
        if (isPresent)
            return;
        if (root1 == null || root1.val != head1.val)
            return;

        head1 = head1.next;
        check(root1.left, head1);
        check(root1.right, head1);
    }
}