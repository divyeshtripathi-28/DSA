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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        q.add(root);
        q.add(null);
        arr.add(root.val);

        while(!q.isEmpty()) {

            if(q.peek() == null) {
                q.remove();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    arr.add(q.peek().val);
                }
            } else {
                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }

                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }

                q.remove();
            }
        }

        return arr;
    }
}