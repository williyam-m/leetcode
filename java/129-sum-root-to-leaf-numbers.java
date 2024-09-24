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
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }
    private void traverse(TreeNode root, int curr) {
        if (root == null)
           return ;
        if (root.left == null && root.right == null) {
            curr *= 10;
            curr += root.val;
            sum += curr;
            return ;
        }
        curr *= 10;
        curr += root.val;
        traverse(root.left, curr);
        traverse(root.right, curr);
    }
}