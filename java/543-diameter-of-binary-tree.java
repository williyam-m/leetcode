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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfsHeight(root);
        return diameter;
    }
    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}