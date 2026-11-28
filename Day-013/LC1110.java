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
    public TreeNode giveForest(TreeNode root, TreeNode mainRoot, HashSet<Integer> set, List<TreeNode> list) {
        if(root == null) {
            return null;
        }

        if(set.contains(root.val)) {
            root.left = giveForest(root.left, mainRoot, set, list);
            root.right = giveForest(root.right, mainRoot, set, list);

            if(root.left != null) {
                list.add(root.left);
            }

            if(root.right != null) {
                list.add(root.right);
            }

            return null;
        }

        root.left = giveForest(root.left, mainRoot, set, list);
        root.right = giveForest(root.right, mainRoot, set, list);

        if(root == mainRoot) {
            list.add(root);
        }

        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }

        giveForest(root, root, set, list);

        return list;
    }
}