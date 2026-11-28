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
    public boolean removeNodes(TreeNode root, int target) {
        if(root == null) {
            return false;
        }

        boolean left = removeNodes(root.left, target);
        boolean right = removeNodes(root.right, target);

        if(left) {
            root.left = null;
        }

        if(right) {
            root.right = null;
        }

        if(root.left == null && root.right == null && root.val == target) {
            return true;
        }

        return false;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        removeNodes(root, target);

        if(root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}