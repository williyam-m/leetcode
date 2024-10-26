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
    Map<Integer, Integer> valToMaxHeight = new HashMap<>();
    Map<Integer, Integer> valToHeight = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root, 0, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i)
            ans[i] = valToMaxHeight.get(queries[i]);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int maxHeight) {
        if (root == null)
           return;
        valToMaxHeight.put(root.val, maxHeight);
        dfs(root.left, depth + 1, Math.max(maxHeight, depth + height(root.right)));
        dfs(root.right, depth + 1, Math.max(maxHeight, depth + height(root.left)));
    }

    private int height(TreeNode root) {
        if (root == null)
           return 0;
        if (valToHeight.containsKey(root.val))
           return valToHeight.get(root.val);


        int h = 1 + Math.max(height(root.left), height(root.right));
        valToHeight.put(root.val, h);
        return h;
    }
}