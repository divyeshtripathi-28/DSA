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
    private int st[] = new int [100];
    private int top = -1;

    public void stacking(TreeNode root) {
        if(root == null) {
            return;
        }

        stacking(root.right);

        st[++top] = root.val;

        stacking(root.left);
    }

    public TreeNode increasingBST(TreeNode root) {
        stacking(root);

        TreeNode newTree = new TreeNode(st[top--]);
        TreeNode temp = newTree;

        while(top != -1) {
            temp.left = null;
            temp.right = new TreeNode(st[top--]);

            temp = temp.right;
        }

        return newTree;
    }
}