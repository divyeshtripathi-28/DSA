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
    public TreeNode build(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if(ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);

        for(int i = is; i <= ie; i++) {
            if(postorder[pe] == inorder[i]) {
                root.left = build(inorder, postorder, is, i - 1, ps, ps - 1 + i - is);
                root.right = build(inorder, postorder, i + 1, ie, ps + i - is, pe - 1);
                break;
            }
        }

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}