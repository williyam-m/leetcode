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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
           return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        boolean alter = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                if (alter) {
                    TreeNode node = q.pollLast();
                    if (node.right != null)
                       q.addFirst(node.right);
                    if (node.left != null)
                       q.addFirst(node.left);
                    list.add(node.val);
                }
                else {
                    TreeNode node = q.pollFirst();
                    if (node.left != null)
                       q.addLast(node.left);
                    if (node.right != null)
                       q.addLast(node.right);
                    list.add(node.val);
                }
            }
            alter = !alter;
            ans.add(list);
        }
        return ans;
        /*if (root == null)
           return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        int alter = 0;
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
            if (alter++ % 2 == 1)
               Collections.reverse(list);
            ans.add(list);
        }
        return ans;
        */
    }
}