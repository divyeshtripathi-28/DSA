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
    public void longest(TreeNode root, int[] max, int length, boolean left) {
        if(root == null) {
            max[0] = Math.max(max[0], length);
            length = -1;
            return;
        }

        int currlength = length;

        length += 1;

        if(left) {
            longest(root.left, max, length, !left);
        } else {
            longest(root.right, max, length, !left);
        }

        left = !left;
        length = 0;

        if(left) {
            longest(root.left, max, length, !left);
        } else {
            longest(root.right, max, length, !left);
        }
    }
    public int longestZigZag(TreeNode root) {
        int[] max = {-1};

        longest(root, max, -1, true);

        return max[0];
    }
}