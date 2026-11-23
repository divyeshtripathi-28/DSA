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
    public TreeNode search(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val == key) {
            return root;
        }

        if(root.val > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode findParent(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode curr = root;

        while(curr != null && curr.val != key) {
            parent = curr;

            if(curr.val > key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return parent;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode del = search(root, key);
        if(del == null) {
            return root;
        }

        if(del.left == null && del.right == null) {
            if(del == root) {
                return null;
            }
            TreeNode parent = findParent(root, key);
            if(parent.left == del) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            return root;
        }

        if(del.right == null) {
            del.val = del.left.val;
            del.right = del.left.right;
            del.left = del.left.left;
            return root;
        }

        if(del.left == null) {
            del.val = del.right.val;
            del.left = del.right.left;
            del.right = del.right.right;
            return root;
        }

        TreeNode temp = del.right;
        TreeNode parent = del;

        while(temp.left != null) {
            parent = temp;
            temp = temp.left;
        }

        del.val = temp.val;

        if(parent == del) {
            parent.right = temp.right;
        } else {
            parent.left = temp.right;
        }
        return root;
    }
}