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
    public TreeNode bst(int[] nums, int low, int high) {
        if(low == high) {
            return new TreeNode(nums[low]);
        }

        if(low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = bst(nums, low, mid - 1);
        TreeNode right = bst(nums, mid + 1, high);

        root.left = left;
        root.right = right;

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }
}