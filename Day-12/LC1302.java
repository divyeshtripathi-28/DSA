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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int sum = 0;

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    sum = 0;
                }
            } else {
                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }

                sum += curr.val;
            }
        }

        return sum;
    }
}