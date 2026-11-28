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
    public List<List<Integer>> sum(TreeNode root, int targetSum, List<List<Integer>> arr, List<Integer> list) {
        if(root == null) {
            return arr;
        }

        list.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum) {
            arr.add(new ArrayList<>(list));
        }

        sum(root.left, targetSum - root.val, arr, list);
        sum(root.right, targetSum - root.val, arr, list);
        list.remove(list.size() - 1);

        return arr;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        return sum(root, targetSum, arr, list);
    }
}
