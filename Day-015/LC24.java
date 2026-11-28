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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp1 = head;
        ListNode temp2 = head.next;

        temp1.next = temp2.next;
        temp2.next = temp1;
        head = temp2;
        ListNode prev = temp1;
        ListNode next;
        temp1 = temp1.next;

        while(temp1 != null && temp1.next != null) {
            temp2 = temp1.next;
            next = temp2.next;
            temp2.next = temp1;
            prev.next = temp2;
            temp1.next = next;

            prev = temp1;
            temp1 = temp1.next;
        }

        return head;
    }
}