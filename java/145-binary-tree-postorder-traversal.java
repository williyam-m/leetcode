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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        Collections.reverse(ans);
        return ans;
    }
    /*
     * List<Integer> ans = new ArrayList<>();
     * public List<Integer> postorderTraversal(TreeNode root) {
     * postorderTraversalHelper(root);
     * return ans;
     * }
     * private void postorderTraversalHelper(TreeNode root) {
     * if (root == null)
     * return;
     * 
     * postorderTraversalHelper(root.left);
     * postorderTraversalHelper(root.right);
     * ans.add(root.val);
     * }
     */
}