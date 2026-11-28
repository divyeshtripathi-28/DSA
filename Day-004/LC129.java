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
    int sumNum = 0;
    public void sum(TreeNode root, int num) {
        if(root == null) {
            return;
        }

        int currNum = num * 10 + root.val;

        if(root.left == null && root.right == null) {
            sumNum += currNum;
            return;
        }

        sum(root.left, currNum);
        sum(root.right, currNum);
    }
    public int sumNumbers(TreeNode root) {
        sumNum = 0;
        sum(root, 0);

        return sumNum;
    }
}