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
    public TreeNode backTrack(int[] preorder, int[] postorder, int preS, int preE, int postS, int postE) {
        if(preS > preE || postS > postE) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preS]);

        if(preS == preE) {
            return root;
        }

        for(int i = postS; i <= postE; i++) {
            if(postorder[i] == preorder[preS + 1]) {
                root.left = backTrack(preorder, postorder, preS + 1, preS + i - postS + 1, postS, i);
                root.right = backTrack(preorder, postorder, preS + i - postS + 2, preE, postS + i - postS + 1, postE - 1);
                break;
            }
        }

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return backTrack(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }
}