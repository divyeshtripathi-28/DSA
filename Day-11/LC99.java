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
    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < list.size(); i++) {
            pq.add(list.get(i).val);
        }

        int i = 0;
        int first = 0;
        int second = 0;

        while(i < list.size()) {
            if(list.get(i).val != pq.remove()) {
                first = i;
                break;
            }
            i++;
        }
        i++;

        while(i < list.size()) {
            if(list.get(i).val != pq.remove()) {
                second = i;
                break;
            }
            i++;
        }

        int temp = list.get(first).val;
        list.get(first).val = list.get(second).val;
        list.get(second).val = temp;
    }
}