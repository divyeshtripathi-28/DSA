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
    public void inOrderTraversal(ArrayList<Integer> arr, TreeNode root) {
        if(root == null) {
            return;
        }

        inOrderTraversal(arr, root.left);
        arr.add(root.val);
        inOrderTraversal(arr, root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        inOrderTraversal(arr, root);

        int min = Math.abs(arr.get(0) - arr.get(1));

        for(int i = 1; i < arr.size() - 1; i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i+1)));
        }

        return min;
    }
}