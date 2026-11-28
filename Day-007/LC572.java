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
    public boolean isTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        boolean left = isTree(root1.left, root2.left);
        boolean right = isTree(root1.right, root2.right);

        if(left && right) {
            return true;
        }

        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }

        if(root.val == subRoot.val && isTree(root, subRoot)) {
            return true;
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        if(left || right) {
            return true;
        }

        return false;
    }
}