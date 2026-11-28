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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();

        ListNode curr = head;

        while(curr.next != null) {
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
                set.add(curr.val);
            } else {
                curr = curr.next;
            }
        }

        curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(set.contains(curr.val)) {
                if(prev != null) {
                    prev.next = curr.next;
                    curr = prev.next;
                } else {
                    head = head.next;
                    curr = head;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}