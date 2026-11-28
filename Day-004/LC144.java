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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> ll = new ArrayList<>();

        ll.add(root.val);

        List<Integer> left = preorderTraversal(root.left);
        int i = 0;

        while(i < left.size()) {
            ll.add(left.get(i));
            i++;
        }

        List<Integer> right = preorderTraversal(root.right);
        i = 0;

        while(i < right.size()) {
            ll.add(right.get(i));
            i++;
        }

        return ll;

    }
}