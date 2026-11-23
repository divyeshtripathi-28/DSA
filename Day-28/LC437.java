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
    public void sum(TreeNode root, long targetSum, int count[]) {
        if(root == null) {
            return;
        }

        targetSum -= root.val;

        if(targetSum == 0) {
            count[0]++;
        }

        sum(root.left, targetSum, count);
        sum(root.right, targetSum, count);
    }

    public void countSum(TreeNode root, long targetSum, int arr[]) {
        if(root == null) {
            return;
        }
        sum(root, targetSum, arr);
        countSum(root.left, targetSum, arr);
        countSum(root.right, targetSum, arr);
    }
    public int pathSum(TreeNode root, int targetSum) {
        int arr[] = {0};

        countSum(root,(long) targetSum, arr);

        return arr[0];
    }
}