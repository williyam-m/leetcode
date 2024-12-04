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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
           return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null)
                   q.offer(node.left);
                if (node.right != null)
                   q.offer(node.right);
                list.add(node.val);
            }
            ans.add(list);
        }
        return ans;
    }
}