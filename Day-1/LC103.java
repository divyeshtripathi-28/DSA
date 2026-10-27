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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> main = new ArrayList<>();
        boolean right = true;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        List<Integer> dum = new ArrayList<>();

        while(!q.isEmpty()) {
            if(q.peek() == null) {
                main.add(dum);
                right = !right;
                dum = new ArrayList<>();
                q.remove();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(right) {
                    dum.add(q.peek().val);
                } else {
                    dum.add(0, q.peek().val);
                }

                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }

                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }

                q.remove();
            }
        }

        return main;
    }
}
