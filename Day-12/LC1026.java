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
    public int giveMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        int left = giveMax(root.left);
        int right = giveMax(root.right);

        int max = Math.max(left, right);

        return Math.max(root.val, max);
    }

    public int giveMin(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        int left = giveMin(root.left);
        int right = giveMin(root.right);

        int min = Math.min(left, right);

        return Math.min(root.val, min);
    }

    public void maxDiff(TreeNode root, int[] max) {
        if(root == null) {
            return;
        }

        if(root.right != null) {
            int rightMin = giveMin(root.right);
            int rightMax = giveMax(root.right);

            max[0] = Math.max(max[0],Math.max(Math.abs(root.val - rightMin), Math.abs(root.val - rightMax)));
        }

        if(root.left != null) {
            int leftMin = giveMin(root.left);
            int leftMax = giveMax(root.left);

            max[0] = Math.max(max[0],Math.max(Math.abs(root.val - leftMin), Math.abs(root.val - leftMax)));
        }

        maxDiff(root.left, max);
        maxDiff(root.right, max);
    }

    public int maxAncestorDiff(TreeNode root) {
        int max[] = {0};

        maxDiff(root, max);

        return max[0];
    }
}