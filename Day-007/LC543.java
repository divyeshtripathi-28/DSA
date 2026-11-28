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
    class Info {
        int diam;
        int height;

        public Info(int d, int h) {
            this.diam = d;
            this.height = h;
        }
    }
    public Info diamAndHeight(TreeNode root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info left = diamAndHeight(root.left);
        Info right = diamAndHeight(root.right);

        int diamLeft = left.diam;
        int diamRight = right.diam;

        int heightL = left.height;
        int heightR = right.height;

        int maxHeight = Math.max(heightL, heightR) + 1;

        int maxDiam =  Math.max(heightL + heightR, diamLeft);
        maxDiam =  Math.max(maxDiam, diamRight);

        return new Info(maxDiam, maxHeight);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diamAndHeight(root).diam;
    }
}