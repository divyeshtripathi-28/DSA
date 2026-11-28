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
class BSTIterator {
    int i = 0;
    boolean no = false;
    TreeNode newRoot;

    List<TreeNode> list = new ArrayList<>();


    public BSTIterator(TreeNode root) {
        newRoot = root;
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    
    public int next() {
        if(!no) {
            inorder(newRoot, list);
            no = true;
        }

        int j = i;
        
        i++;
        return list.get(j).val;
    }
    
    public boolean hasNext() {
        if(!no) {
            inorder(newRoot, list);
            no = true;
        }
        return i < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */