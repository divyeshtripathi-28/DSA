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
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;
        int comp = 1;
        boolean removed = true;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        while(temp != null) {
            if(!set.contains(temp.val)) {
                if(!removed) {
                    comp++;
                    removed = true;
                }
            } else {
                removed = false;
            }
            temp = temp.next;
        }

        if(removed) {
            comp--;
        }

        return comp;
    }
}