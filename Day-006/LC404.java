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
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null) {
            return 0;
        }

        if(root.left.left == null && root.left.right == null) {
            return root.left.val;
        }

        return 0;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int sum = sum(root);

        return leftSum + rightSum + sum;
    }
}
