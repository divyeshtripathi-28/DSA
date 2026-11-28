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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();

            if(curr == null) {
                list.add(max);
                max = Integer.MIN_VALUE;

                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                max = Math.max(curr.val, max);

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return list;

    }
}