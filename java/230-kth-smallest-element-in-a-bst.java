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
    int ans = -1;
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }
    private void inOrder (TreeNode root, int k) {
        if (root == null)
           return ;
        
        inOrder(root.left, k);
        if (++rank == k)
            ans = root.val;
        inOrder(root.right, k);
    }

    /*
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        dfs(root, maxHeap, k);
        return maxHeap.peek();
    }
    private void dfs (TreeNode root, Queue<Integer> maxHeap, int k) {
        if (root == null)
           return ;
        
        maxHeap.offer(root.val);
        if (maxHeap.size() > k)
           maxHeap.poll();
        dfs(root.left, maxHeap, k);
        dfs(root.right, maxHeap, k);
    }
    */
}