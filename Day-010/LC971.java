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
    int i = 0;
    public void flip(TreeNode root, int[] voyage, List<Integer> list) {
        if(root == null) {
            return;
        }

        if(root.val != voyage[i]) {
            list.add(-1);
            return;
        }

        i++;


        if(root.left == null && root.right == null) {
            return;
        }

        if(root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            list.add(root.val);

            flip(root.left, voyage, list);
            flip(root.right, voyage, list);
            return;
        }

        flip(root.left, voyage, list);
        flip(root.right, voyage, list);
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i = 0;
        List<Integer> list = new ArrayList<>();
        flip(root, voyage, list);

        if(list.contains(-1)) {
            list.clear();
            list.add(-1);
        }

        return list;
    }
}