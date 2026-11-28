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
    public void paths(TreeNode root, List<String> list, StringBuilder sb) {
        if(root == null) {
            return;
        }

        int length = sb.length();

        sb.append(root.val);

        if(root.left == null && root.right == null) {
            StringBuilder sb2 = new StringBuilder(sb);
            list.add(sb2.toString());
            sb.setLength(length);
            return;
        }

        sb.append('-');
        sb.append('>');

        paths(root.left, list, sb);
        paths(root.right, list, sb);

        sb.setLength(length);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        paths(root, list, new StringBuilder());

        return list;
    }
}