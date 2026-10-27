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
    public void preorder1(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(101);
            return;
        }
        arr.add(root.val);
        preorder1(root.left, arr);
        preorder1(root.right, arr);
    }

    public void preorder2(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(101);
            return;
        }
        arr.add(root.val);
        preorder2(root.right, arr);
        preorder2(root.left, arr);
    }
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        preorder1(root.left, arr1);
        preorder2(root.right, arr2);

        int i = 0;

        while(i < arr1.size() && i < arr2.size()) {
            if(arr1.get(i) != arr2.get(i)) {
                return false;
            }
            i++;
        }

        if(i < arr1.size() || i < arr2.size()) {
            return false;
        }

        return true;
    }
}