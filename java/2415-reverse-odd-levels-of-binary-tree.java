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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int odd = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (odd++ % 2 == 1)
               reverseValues(new ArrayDeque<>(queue));
        }
        return root;
    }
    public void reverseValues(Deque<TreeNode> dq) {
        while (!dq.isEmpty()) {
            int temp = dq.getFirst().val;
            dq.pollFirst().val = dq.getLast().val;
            dq.pollLast().val = temp;
        }
    }
}