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
        int maxLevel = 1;
        int maxLevelSum = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int currLevelSum = 0;
            for (int i = queue.size(); i > 0; --i) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                currLevelSum += currNode.val;
            }
            if (maxLevelSum < currLevelSum) {
                maxLevelSum = currLevelSum;
                maxLevel = level;
            }
            ++level;
        }
        return maxLevel;
    }
}