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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int result = root.val;

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    result = q.peek().val;
                }
            } else {
                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return result;
    }
}