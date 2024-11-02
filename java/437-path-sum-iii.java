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
    HashMap<Long, Integer> map = new HashMap<>();
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {

        dfs(root, 0, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null)
           return ;


        sum += root.val;
        if (map.containsKey(sum - targetSum))
           ans += map.get(sum - targetSum);

        if (sum == targetSum)
           ++ans;

        map.merge(sum, 1, Integer::sum);
        
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);

        map.merge(sum, -1, Integer::sum);
        if (map.get(sum) == 0)
           map.remove(sum);
    }
}