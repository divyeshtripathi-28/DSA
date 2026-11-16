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
    public boolean isPath(ListNode head, ListNode newHead, TreeNode root) {
        if(newHead == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        boolean leftHead = false;
        boolean rightHead = false;

        if(newHead.val == root.val) {
            leftHead = isPath(newHead, newHead.next, root.left);
            rightHead = isPath(newHead, newHead.next, root.right);
        }

        if(head != newHead) {
            return leftHead || rightHead;
        }

        boolean left = isPath(newHead, newHead, root.left);
        boolean right = isPath(newHead, newHead, root.right);

        return left || right || leftHead || rightHead;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isPath(head, head, root);
    }
}