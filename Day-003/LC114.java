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
    public TreeNode flat(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);

        if(left == null) {
            return root;
        }

        root.right = left;
        TreeNode temp = left;

        while(temp.right != null) {
            temp = temp.right;
        }

        temp.right = right;
        root.left = null;
        return root;
    }
    public void flatten(TreeNode root) {
        root = flat(root);
        // if(root == null || (root.left == null && root.right == null)) {
        //     return;
        // }

        // flatten(root.left);
        // flatten(root.right);

        // if(root.left == null) {
        //     return;
        // }

        // TreeNode temp = root.right;
        // root.right = root.left;
        // root.right.right = temp;
        // root.left = null;
    }
}
