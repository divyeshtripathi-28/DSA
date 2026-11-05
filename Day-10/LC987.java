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
    class Info implements Comparable<Info> {
        int data;
        int col;
        int row;

        public Info(int d, int c, int r) {
            this.data = d;
            this.col = c;
            this.row = r;
        }

        @Override
        public int compareTo(Info i2) {
            if(this.col == i2.col) {
                if(this.row != i2.row) {
                    return this.row - i2.row;
                }
                return this.data - i2.data;
            }
            return this.col - i2.col;
        }
    }

    public void traversal(PriorityQueue<Info> pq, TreeNode root, int i, int j) {
        if(root == null) {
            return;
        }

        traversal(pq, root.left, i - 1, j + 1);
        pq.add(new Info(root.val, i, j));
        traversal(pq, root.right, i + 1, j + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        traversal(pq, root, 0, 0);

        int currCol = pq.peek().col;

        while(!pq.isEmpty()) {
            if(pq.peek().col != currCol) {
                currCol = pq.peek().col;
                list.add(new ArrayList<>(arr));
                arr.clear();
            } else {
                arr.add(pq.remove().data);
            }
        }

        list.add(new ArrayList<>(arr));

        return list;
    }
}