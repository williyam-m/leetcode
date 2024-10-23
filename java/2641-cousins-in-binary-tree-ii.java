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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        root.val = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            int sum = 0;
            for (TreeNode q : queue) {
                if (q.left != null)
                   sum += q.left.val;
                if (q.right != null)
                   sum += q.right.val;
            }

            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    int val = sum - node.right.val - node.left.val;
                    node.left.val = val;
                    node.right.val = val;
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else {
                    if (node.left != null) {
                        node.left.val = sum - node.left.val;
                        queue.add(node.left);
                    } 
                    else if (node.right != null) {
                        node.right.val = sum - node.right.val;
                        queue.add(node.right);
                    }
                }
            }
        }
        return root;
    }
}