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
    private boolean isValid = true;
    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isValid;
    }
    private void inOrder(TreeNode root) {
        if (!isValid || root == null) {
            return;
        }
        inOrder(root.left);
        if (this.prev != null && this.prev.val >= root.val) {
            this.isValid = false;
            return;
        }
        this.prev = root;
        inOrder(root.right);
    }
}