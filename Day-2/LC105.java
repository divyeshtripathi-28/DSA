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
    public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        for(int i = is; i <= ie; i++) {
            if(preorder[ps] == inorder[i]) {
                root.left = build(preorder, inorder, ps + 1, ps + i - is, is, i - 1);
                root.right = build(preorder, inorder, ps + i - is + 1, pe, i + 1, ie);
                break;
            }
        }

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
