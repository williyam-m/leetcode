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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        preOrder(root, targetSum, new ArrayList<>(), 0);
        return ans;
    }
    private void preOrder(TreeNode root, int targetSum, List<Integer> curr, int sum) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            if (sum == targetSum - root.val) {
                curr.add(root.val);
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return ;
        }
        
        curr.add(root.val);
        sum += root.val;

        preOrder(root.left, targetSum, curr, sum);
        preOrder(root.right, targetSum, curr, sum);
        curr.remove(curr.size() - 1);
    }
}