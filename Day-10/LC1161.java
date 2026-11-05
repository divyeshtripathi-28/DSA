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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int minLevel = 1;
        int level = 1;
        int sum = 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();

            if(curr == null) {
                if(maxSum < sum) {
                    maxSum = sum;
                    minLevel = level;
                }
                if(q.isEmpty()) {
                    break;
                }
                q.add(null);
                sum = 0;
                level++;
            } else {
                sum += curr.val;
                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return minLevel;
    }
}