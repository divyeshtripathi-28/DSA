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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            if(set.contains(temp.val)) {
                if(temp == head) {
                    temp = temp.next;
                    head = temp;
                } else {
                    prev.next = temp.next;
                    temp = prev.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}