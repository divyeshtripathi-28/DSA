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
    public void addRow(TreeNode root, int val, int depth, int curr) {
        if(root == null) {
            return;
        }
        if(curr == depth - 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);

            TreeNode temp = root.left;
            root.left = left;
            left.left = temp;

            temp = root.right;
            root.right = right;
            right.right = temp;

            return;
        }

        addRow(root.left, val, depth, curr + 1);
        addRow(root.right, val, depth, curr + 1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth, 1);

        return root;
    }
}