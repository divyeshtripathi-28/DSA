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
    public void countGoodNodes(TreeNode root, int[] count, int val, int length) {
        if(root == null) {
            return;
        }

        if(root.val >= val) {
            count[0]++;
            val = root.val;
        }

        length += 1;

        countGoodNodes(root.left, count, Math.max(val, root.val), length);
        countGoodNodes(root.right, count, Math.max(val, root.val), length);
    }
    public int goodNodes(TreeNode root) {
        int[] count = {0};

        countGoodNodes(root, count, root.val, 0);

        return count[0];
    }
}