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
    public TreeNode construct(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        if(low == high) {
            return new TreeNode(nums[low], null, null);
        }

        int max = low;

        for(int i = low + 1; i <= high; i++) {
            if(nums[max] < nums[i]) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, low, max - 1);
        root.right = construct(nums, max + 1, high);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}