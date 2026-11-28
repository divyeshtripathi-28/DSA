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
    public boolean isUnival(TreeNode root, int val) {
        if(root == null) {
            return true;
        }

        boolean left = false;
        boolean right = false;

        if(root.val == val) {
            left = isUnival(root.left, val);
            right = isUnival(root.right, val);
        }

        return left && right;
    }
    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root, root.val);
    }
}