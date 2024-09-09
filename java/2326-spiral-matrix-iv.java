/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < m; ++i)
            Arrays.fill(ans[i], -1);

        while (left <= right && head != null) {
            for (int i = left; i <= right; ++i) {
                if (head == null)
                   break;
                ans[top][i] = head.val;
                head = head.next;
            }
            ++top;
            for (int i = top; i <= bottom; ++i) {
                if (head == null)
                   break;
                ans[i][right] = head.val;
                head = head.next;
            }
            --right;
            for (int i = right; i >= left; --i) {
                if (head == null)
                   break;
                ans[bottom][i] = head.val;
                head = head.next;
            }
            --bottom;
            for (int i = bottom; i >= top; --i) {
                if (head == null)
                   break;
                ans[i][left] = head.val;
                head = head.next;
            }
            ++left;
        }
        return ans;
    }
}