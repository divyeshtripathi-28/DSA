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
    class Info {
        int num;
        int freq;

        public Info(int n, int f) {
            this.num = n;
            this.freq = f;
        }
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Info> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        inorder(root, list);
        Collections.sort(list);

        int i = 0;
        int num = list.get(0);
        int freq = 0;
        while(i < list.size()) {
            if(list.get(i) == num) {
                freq++;
            } else {
                list2.add(new Info(num, freq));
                num = list.get(i);
                freq = 1;
            }
            i++;
        }

        list2.add(new Info(num, freq));

        int maxFreq = 0;

        for(int j = 0; j < list2.size(); j++) {
            maxFreq = Math.max(maxFreq, list2.get(j).freq);
        }

        for(int j = 0; j < list2.size(); j++) {
            if(list2.get(j).freq == maxFreq) {
                result.add(list2.get(j).num);
            }
        }

        int[] arr = result.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}