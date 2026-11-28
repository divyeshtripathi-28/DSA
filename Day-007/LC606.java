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
    public void str(TreeNode root, StringBuilder sb, TreeNode alwaysRoot) {
        if(root == null) {
            return;
        }

        StringBuilder sb2 = new StringBuilder();

        sb2.append(root.val);
        if(root.left == null && root.right != null) {
            sb2.append("()");
        } else {
            str(root.left, sb2, alwaysRoot);
        }
        str(root.right, sb2, alwaysRoot);

        if(root != alwaysRoot) {
            sb2.insert(0, '(');
            sb2.append(')');
        }

        sb.append(sb2);
    }
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        str(root, sb, root);

        return sb.toString();
    }
}