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
    private List<Integer> values = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.size() - 1; ++i)
            min = Math.min(min, values.get(i + 1) - values.get(i));
        return min;
    }
    private void inorder (TreeNode root) {
        if (root == null)
           return ;
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    } 
}