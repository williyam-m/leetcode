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
    public int maxLevelSum(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int max = root.val;
        int ans = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            ++level;
            int len = queue.size();
            int sum = 0;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                   queue.offer(node.left);
                if (node.right != null)
                   queue.offer(node.right);
            }

            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}