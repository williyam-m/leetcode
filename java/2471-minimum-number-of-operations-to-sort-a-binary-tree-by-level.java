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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int[] arr = new int[len];
            int[] arrSorted = new int[len];
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.poll();
                arr[i] = node.val;
                arrSorted[i] = node.val;
                if (node.left != null) {
                   queue.offer(node.left);
                }
                if (node.right != null) {
                   queue.offer(node.right);
                }
            }

            Arrays.sort(arrSorted);
            for (int j = 0; j < len; ++j) {
                if (arr[j] != arrSorted[j]) {
                    int index = indexOf(arr, arrSorted[j]);
                    int temp = arr[j];
                    arr[j] = arr[index];
                    arr[index] = temp;
                    ++ans;
                }
            }
        }
        return ans;
    }
    private int indexOf (int[] arr, int ele) {
        for (int i = 0; i < arr.length; ++i)
            if (arr[i] == ele)
               return i;
        return -1;
    }
}