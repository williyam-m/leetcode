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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            boolean is_x = false, is_y = false;
            int len = queue.size();

            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.val == x)
                    is_x = true;
                else if (node.val == y)
                    is_y = true;
                
                if (node.left != null && node.right != null && (node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y))
                    return false;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (is_x && is_y)
               return true;
            else if (is_x || is_y)
               return false;
        }
        return false;
    }
}