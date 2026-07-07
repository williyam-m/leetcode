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
    private Set<Integer> set = new HashSet<>();
    private boolean flag = false;
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root, k);
        return flag;
    }
    private void inOrder(TreeNode root, int k) {
        if (flag || root == null) {
            return;
        }
        inOrder(root.left, k);
        if (set.contains(k - root.val)) {
            flag = true;
            return;
        }
        set.add(root.val);
        inOrder(root.right, k);
    }
}

/*
class Solution {
    private List<Integer> values = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        for (int l = 0, r = values.size() - 1; l < r; ) {
            if (values.get(l) + values.get(r) == k) {
                return true;
            }
            else if (values.get(l) + values.get(r) > k) {
                --r;
            }
            else {
                ++l;
            }
        }
        return false;
    }
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
    }
}
*/