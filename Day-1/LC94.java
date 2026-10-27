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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> main = new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        int i = 0;

        while(i < left.size()) {
            main.add(left.get(i));
            i++;
        }

        main.add(root.val);

        List<Integer> right = inorderTraversal(root.right);
        i = 0;

        while(i < right.size()) {
            main.add(right.get(i));
            i++;
        }

        return main;
    }
}