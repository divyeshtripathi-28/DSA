/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode bst(ArrayList<Integer> arr, int low, int high) {
        if(low == high) {
            return new TreeNode(arr.get(low));
        }

        if(low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(arr.get(mid));
        root.left = bst(arr, low, mid - 1);
        root.right = bst(arr, mid + 1, high);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }

        return bst(arr, 0, arr.size() -1);
    }
}