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
    public int findSum(TreeNode root, HashMap<Integer,Integer> map) {
        if(root == null) {
            return 0;
        }

        int leftSum = findSum(root.left, map);
        int rightSum = findSum(root.right, map);

        int sum = root.val + leftSum + rightSum;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();

        findSum(root, map);

        int maxFreq = 0;

        for(int key : map.keySet()) {
            maxFreq = Math.max(maxFreq, map.get(key));
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int key : map.keySet()) {
            if(map.get(key) == maxFreq) {
                arr.add(key);
            }
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}