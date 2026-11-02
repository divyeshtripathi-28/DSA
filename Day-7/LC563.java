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
    int tilt = 0;

    public int giveTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int sumL = giveTilt(root.left);
        int sumR = giveTilt(root.right);

        tilt += Math.abs(sumL - sumR);

        return sumL + sumR + root.val;
    }
    public int findTilt(TreeNode root) {
        tilt = 0;
        giveTilt(root);
        return tilt;
    }
}
