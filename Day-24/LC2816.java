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
    public int recursive(ListNode head) {
        if(head.next == null) {
            int val = head.val;
            val = 2 * val;

            head.val = val % 10;
            val = val / 10;
            return val;
        }

        int carry = recursive(head.next);

        int val = head.val;
        val = 2 * val;

        if(carry > 0) {
            val += carry;
        }

        head.val = val % 10;
        val = val / 10;

        return val;
    }
    public ListNode doubleIt(ListNode head) {
        int carry = recursive(head);

        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }
}