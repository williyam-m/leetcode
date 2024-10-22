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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        minHeap.offer((long) root.val);
        boolean flag = false;
        while (!queue.isEmpty()) {
            long value = 0;
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null)
                   list.add(node.left);
                if (node.right != null)
                   list.add(node.right);
            }

            for (TreeNode l : list) {
                queue.add(l);
                value += l.val;
            }

            minHeap.offer(value);
            if (minHeap.size() > k) {
                flag = true;
                minHeap.poll();
            }
        }

        return flag ? minHeap.peek() : -1;
    }
}