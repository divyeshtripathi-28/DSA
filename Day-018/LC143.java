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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next;
        slow.next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode temp1 = head;
        ListNode temp2 = prev;

        while(temp2 != null) {
            next = temp1.next;
            temp1.next = temp2;
            temp1 = next;
            next = temp2.next;
            temp2.next = temp1;
            temp2 = next;
        }

        temp1 = head;

        while(temp1 != null) {
            System.out.print(temp1.val);
            temp1 = temp1.next;
        }
    }
}