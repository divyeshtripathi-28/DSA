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
        int path;
        int max;

        public Info(int p, int m) {
            this.path = p;
            this.max = m;
        }
    }
    public Info maxSum(TreeNode root) {
        if(root == null) {
            return new Info(0, Integer.MIN_VALUE);
        }
        if(root.left == null && root.right == null) {
            return new Info(root.val, root.val);
        }

        Info leftSum = maxSum(root.left);
        Info rightSum = maxSum(root.right);

        int rootMax = Math.max(leftSum.path, 0) + Math.max(rightSum.path, 0) + root.val;
        int childMax = Math.max(leftSum.max, rightSum.max);

        return new Info(Math.max(Math.max(leftSum.path, rightSum.path),0) + root.val, Math.max(rootMax, childMax));
    }
    public int maxPathSum(TreeNode root) {
        Info result = maxSum(root);

        return result.max;
    }
}