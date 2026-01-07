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
    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        long ans = 0;
        long totalSum = dfs(root);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();

            long subTreeSum = (totalSum - currNode.val) * currNode.val;
            ans = Math.max(ans, subTreeSum);

            if (currNode.left != null) {queue.offer(currNode.left);}
            if (currNode.right != null) {queue.offer(currNode.right);}
        }
        return (int) (ans % MOD);
    }

    private long dfs (TreeNode root) {
        if (root == null) {return 0;}
        root.val += dfs(root.left) + dfs(root.right);

        return root.val;
    }
}