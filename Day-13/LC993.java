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
    public int getParent(TreeNode root, int x) {
        if(root == null) {
            return 0;
        }

        if(root.left != null && root.left.val == x) {
            return root.val;
        }

        if(root.right != null && root.right.val == x) {
            return root.val;
        }

        int left = getParent(root.left, x);

        if(left != 0) {
            return left;
        }

        return getParent(root.right, x);
    }

    public int getHeight(TreeNode root, int x) {
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();

            if(curr == null) {
                height++;
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(curr.val == x) {
                    return height;
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return height;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int heightX = getHeight(root, x);
        int heightY = getHeight(root, y);

        if(heightX != heightY) {
            return false;
        }

        int parentX = getParent(root, x);
        int parentY = getParent(root, y);

        if(parentX == parentY) {
            return false;
        }

        return true;
    }
}
