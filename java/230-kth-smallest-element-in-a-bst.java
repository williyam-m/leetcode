/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int k = 0;
    private int val = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return this.val;
    }
    private void inOrder(TreeNode root, int k) {
        if (this.val != -1 || root == null) {
            return;
        }
        inOrder(root.left, k);
        if (++this.k == k) {
            this.val = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}